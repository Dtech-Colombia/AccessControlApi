package co.com.dtech.accesscontrol.modules.parking.controller;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/parking")
public class ParkingController {
	
	@PostMapping(path="/validate")
	public ResponseEntity<String> validate() throws ParseException	{
		double rd = Math.random();
		String response = "0";
		if (rd < 0.6) {
			response = "1";
		}
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
}
