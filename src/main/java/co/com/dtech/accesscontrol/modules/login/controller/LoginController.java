package co.com.dtech.accesscontrol.modules.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.dtech.accesscontrol.common.bean.UserBean;
import co.com.dtech.accesscontrol.modules.login.service.LoginService;

//Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/main")
public class LoginController {
	@Autowired
	private LoginService loginService;

	
	/**
	 * Method to Sign in
	 * @param loginRequest
	 * @return the UserDTO or a handle exception
	 * @throws Exception
	 */
	@PostMapping(path = "/login")
	public ResponseEntity<UserBean> doLogin(@RequestBody UserBean user) throws Exception{
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("").toUri();
		UserBean response = loginService.doLogin(user);
		return new ResponseEntity<UserBean>(response,HttpStatus.OK);
		
	}

}
