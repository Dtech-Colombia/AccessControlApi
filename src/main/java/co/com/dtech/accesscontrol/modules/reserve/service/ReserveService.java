package co.com.dtech.accesscontrol.modules.reserve.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.dtech.accesscontrol.common.bean.ParkingBean;
import co.com.dtech.accesscontrol.common.bean.ParkingReserveBean;
import co.com.dtech.accesscontrol.common.entity.Parking;
import co.com.dtech.accesscontrol.common.entity.ParkingReserve;
import co.com.dtech.accesscontrol.common.entity.Status;
import co.com.dtech.accesscontrol.common.enums.StatusEnum;
import co.com.dtech.accesscontrol.common.util.JsonUtils;
import co.com.dtech.accesscontrol.repository.ParkingRepository;
import co.com.dtech.accesscontrol.repository.ParkingReserveRepository;
import co.com.dtech.accesscontrol.repository.StatusRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class ReserveService {
	private static final Logger errorLog = LogManager.getLogger("error");
	
	@Autowired
	private ParkingReserveRepository parkingReserveRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ParkingRepository parkingRepository;
	
	public List<ParkingBean> getParkings(){
		List<Parking> parkings =parkingRepository.findAllByReserveNeeded("S");		
		return parkings.stream().map(Parking::getBean).collect(Collectors.toList());
	}

	public ParkingReserveBean saveReserve(ParkingReserveBean targetReserve) throws Exception {
		ParkingBean parking = targetReserve.getParking();
		Integer actualReserves = parkingReserveRepository.countActiveReserve(targetReserve.getInitialDate(),targetReserve.getFinalDate(),StatusEnum.ACTIVA.getId(),targetReserve.getParking().getId());
		errorLog.error("actualReserves: " + actualReserves);
		errorLog.error("parking.getTotalAvailable: " + parking.getTotalAvailable());
		errorLog.error("parking.getReservedLots(): " + parking.getReservedLots());
		if (actualReserves > (parking.getTotalAvailable()-parking.getReservedLots())) {
			throw new Exception("No hay celdas disponibles");
		}
		long expirationMillis = targetReserve.getInitialDate().getTime();
		Date expirationDate = new Date(expirationMillis + (15*60*1000));// 15 minutos de expiración;		
		targetReserve.setExpirationDate(expirationDate);
		String json = JsonUtils.getJsonFromObject(targetReserve);
		ParkingReserve reserve = JsonUtils.getObjectFromJson(json, ParkingReserve.class);
		Status status = statusRepository.getById(StatusEnum.ACTIVA.getId());
		reserve.setStatus(status);
		reserve = parkingReserveRepository.save(reserve);		
		return reserve.getBean();
	}

	
}
