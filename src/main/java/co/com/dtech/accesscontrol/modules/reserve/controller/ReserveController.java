package co.com.dtech.accesscontrol.modules.reserve.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.dtech.accesscontrol.common.bean.ParkingBean;
import co.com.dtech.accesscontrol.common.bean.ParkingReserveBean;
import co.com.dtech.accesscontrol.modules.reserve.service.ReserveService;

//Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/reserve")
public class ReserveController {

	@Autowired
	private ReserveService reserveService;

	@GetMapping(path="/parkings")
	public ResponseEntity<List<ParkingBean>> getParkings() throws ParseException	{
		return new ResponseEntity<List<ParkingBean>>(reserveService.getParkings(),HttpStatus.OK);
		
	}
	@PostMapping(path = "/save")
	public ResponseEntity<ParkingReserveBean> saveReserve(@RequestBody ParkingReserveBean body) throws Exception	{
		return new ResponseEntity<ParkingReserveBean>(reserveService.saveReserve(body),HttpStatus.OK);
		
	}
}
