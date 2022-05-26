package co.com.dtech.accesscontrol.security;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.dtech.accesscontrol.security.jwt.AuthenticationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger log = LogManager.getLogger("error");

	
	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<String> handleException(Throwable e) {
		log.error(e.getMessage(),e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
		log.error(e.getMessage(),e);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}
	
	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<String> handleDataIngerityException(DataIntegrityViolationException e) {
		log.error(e.getMessage(),e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR DE ACCESO A DATOS");
	}

}
