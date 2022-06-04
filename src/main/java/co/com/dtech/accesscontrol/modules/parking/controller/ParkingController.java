package co.com.dtech.accesscontrol.modules.parking.controller;

import java.text.ParseException;

import co.com.dtech.accesscontrol.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.dtech.accesscontrol.modules.parking.model.ParkingRequestBean;
import co.com.dtech.accesscontrol.modules.parking.service.ParkingService;

//Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/parking")
public class ParkingController {

	@Autowired 
	private ParkingService parkingService;

	@PostMapping(path = "/validate")
	public ResponseEntity<String> validate(@RequestBody ParkingRequestBean request) throws ParseException {
		if (parkingService.validate(request)) {
			return new ResponseEntity<String>(StringUtils.OK, HttpStatus.OK);
		}
		return new ResponseEntity<String>(StringUtils.EMPTY, HttpStatus.FORBIDDEN);
	}
	
	@PostMapping(path = "/parkingExit")
	public ResponseEntity<String> parkingExit(@RequestBody ParkingRequestBean request ){
		parkingService.parkingExit(request);
		return new ResponseEntity<String>(StringUtils.OK, HttpStatus.OK);
	}
}
