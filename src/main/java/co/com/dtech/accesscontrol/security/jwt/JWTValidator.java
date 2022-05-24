package co.com.dtech.accesscontrol.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.com.dtech.accesscontrol.common.bean.UserBean;
import co.com.dtech.accesscontrol.security.MultiReadHttpServletRequest;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JWTValidator {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Value("${jwt.http.request.header}")
	private String tokenHeader;

	public void applyAuth(MultiReadHttpServletRequest hsr, String uri) throws AuthenticationException{
		boolean isLoginPage = uri.equals("/main/login") || uri.equals("/main/logout");
		
		if (!isLoginPage) {
			UserBean user = this.getUser(hsr, isLoginPage);
			if (user != null) {
				hsr.setAttribute("user", user);
			}
			if (user == null) {
				throw new AuthenticationException("Debe autenticarse previamente");
			}
		}
	}

	private UserBean getUser(MultiReadHttpServletRequest request, boolean isLoginPage) {
		UserBean user = null;
		String token = null;
		String data = request.getHeader(tokenHeader);
		if (data != null && data.startsWith("Bearer ")) {
			try {
				data = data.substring(7);
				user = jwtTokenUtil.getUserFromToken(data);				
				if (jwtTokenUtil.canTokenBeRefreshed(data)) {
					token = jwtTokenUtil.refreshToken(data);					
				}else {
					throw new AuthenticationException("Su sesión ha expirado, debe ingresar nuevamente.");
				}
			}catch (Exception e) {
				e.printStackTrace(System.err);
				if (!isLoginPage) {
					if (e instanceof ExpiredJwtException) {
						throw new AuthenticationException("Su sesión ha expirado, debe ingresar nuevamente.");						
					}
					throw e;
				}
			}
		} 
		
		if (token != null && user != null) {
			request.setAttribute("token", token);
			user.setToken(token);
			return user;
		}
		return null;
	}
}
