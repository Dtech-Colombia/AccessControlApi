package co.com.dtech.accesscontrol.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.output.TeeOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.DelegatingServletOutputStream;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import co.com.dtech.accesscontrol.security.jwt.AuthenticationException;
import co.com.dtech.accesscontrol.security.jwt.JWTValidator;

@Component
public class AuthenticationFilter extends GenericFilterBean {
	
	@Autowired
	private JWTValidator validator;

	private static final Logger log = LogManager.getLogger("tramas-log");
	private static final Logger errorLog = LogManager.getLogger("error-log");

	private static List<String> bodyMethods = null;

	static {
		bodyMethods = new ArrayList<String>();
		bodyMethods.add(HttpMethod.POST.name());
		bodyMethods.add(HttpMethod.PUT.name());
		bodyMethods.add(HttpMethod.DELETE.name());
	}

	private String extractPostRequestBody(HttpServletRequest request) {
		Scanner s = null;
		InputStream in = null;
		try {
			in = request.getInputStream();
			s = new Scanner(in, StandardCharsets.UTF_8);
			s.useDelimiter("\\A");
			String str = s.hasNext() ? s.next() : "";
			str = str.replace("\n", " ");
			return str;
		} catch (IOException e) {
			errorLog.error("Error obteniendo el cuerpo de la peticion",e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
			try {
				if (s != null)
					s.close();
			} catch (Exception e) {
			}
		}
		return null;
	}

	private String extractParameters(HttpServletRequest httpServletRequest) {
		StringBuilder sb = new StringBuilder();
		Enumeration<String> params = httpServletRequest.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			sb.append(paramName).append(" = ").append(httpServletRequest.getParameter(paramName)).append("|");
		}
		return sb.toString();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		MultiReadHttpServletRequest hsr = new MultiReadHttpServletRequest((HttpServletRequest) request);
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = hsr.getRequestURI().substring(hsr.getContextPath().length());

		try {
			resp = new HttpServletResponseWrapper(resp) {
				@Override
				public ServletOutputStream getOutputStream() throws IOException {
					return new DelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(), baos));
				}

				@Override
				public PrintWriter getWriter() throws IOException {
					return new PrintWriter(
							new DelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(), baos)));
				}
			};
			logRequest(hsr, uri);
			validator.applyAuth(hsr, uri);
			chain.doFilter(hsr, resp);
		} catch (Exception ex) {
			baos.reset();
			errorLog.error(ex.getMessage(),ex);
			int respCode = ex instanceof AuthenticationException ? HttpServletResponse.SC_UNAUTHORIZED : HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			resp.sendError( respCode, ex.getMessage());
			return;
		}
		finally
		{
			logResponse(baos, uri);
		}
	}

	private void logRequest(HttpServletRequest hsr,String uri) throws IOException {
		String req = null;
		if (bodyMethods.contains(hsr.getMethod())) {
			req =extractPostRequestBody(hsr);
			/*if (req != null && !"".equals(req)) {
				Gson gson = new Gson();
				JsonObject obj = gson.fromJson(req, JsonObject.class);
				String password = obj.get("password") == null? "":obj.get("password").getAsString();
				if (password != null && !"".equals(password)) {
					obj.addProperty("password", "----");					
				}		
				req = obj.toString();
				
			}*/
		}else {
			req =extractParameters(hsr);			
		}
		log.debug(MessageFormat.format("REQUEST (%s) : %s", uri,req));
	}

	private void logResponse(ByteArrayOutputStream baos, String uri) {
		String resp = new String(baos.toByteArray());
		if (resp != null && !"".equals(resp)) {
			/*Gson gson = new Gson();
			JsonObject obj = gson.fromJson(resp, JsonObject.class);
			String password = obj.get("password") == null? "":obj.get("password").getAsString();
			if (password != null && !"".equals(password)) {
				obj.addProperty("password", "----");					
			}	*/	
			log.debug(MessageFormat.format("RESPONSE (%s) : %s", uri, resp.toString()));
		}
	}

}
