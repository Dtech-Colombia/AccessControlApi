package co.com.dtech.accesscontrol.security;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import co.com.dtech.accesscontrol.common.StringUtils;
import co.com.dtech.accesscontrol.common.bean.GenericBean;

@ControllerAdvice
public class ResponseTokenAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(final Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof GenericBean) {
			String token = (String) ((ServletServerHttpRequest) request).getServletRequest().getAttribute("token");
			if (!StringUtils.isNullorEmpty(token)) {
				GenericBean bean = (GenericBean) body;
				bean.setToken(token);
			}
		}

		return body;
	}

}
