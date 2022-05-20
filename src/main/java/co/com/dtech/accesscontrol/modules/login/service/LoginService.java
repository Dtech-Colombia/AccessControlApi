package co.com.dtech.accesscontrol.modules.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.dtech.accesscontrol.entities.User;
import co.com.dtech.accesscontrol.repository.UserRepository;
import co.com.dtech.accesscontrol.security.EncrypAESB64;
import co.com.dtech.accesscontrol.security.jwt.AuthenticationException;
import co.com.dtech.accesscontrol.security.jwt.JwtTokenUtil;
import co.com.dtech.accesscontrol.security.model.UserBean;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class LoginService {
	
	@Autowired
	private UserRepository userRepository; 
	
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	public UserBean doLogin(UserBean user) {		
		User userDb = userRepository.findByUsername(user.getUsername());
		String encPass = EncrypAESB64.encryptAES(user.getPassword());
		if (userDb ==null || !userDb.getPassword().equals(encPass)) {
			throw new AuthenticationException("Usuario o contraseña incorrecta");
		}
		UserBean userResponse = userDb.getBean();
		userResponse.setToken( jwtTokenUtil.doGenerateToken(userDb));
		return userResponse;		
	}

}
