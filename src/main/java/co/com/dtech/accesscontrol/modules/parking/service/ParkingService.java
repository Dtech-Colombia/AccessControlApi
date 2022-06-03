package co.com.dtech.accesscontrol.modules.parking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.dtech.accesscontrol.common.entity.Parking;
import co.com.dtech.accesscontrol.common.entity.ParkingHistory;
import co.com.dtech.accesscontrol.common.entity.ParkingReserve;
import co.com.dtech.accesscontrol.common.entity.Tag;
import co.com.dtech.accesscontrol.common.entity.User;
import co.com.dtech.accesscontrol.common.enums.StatusEnum;
import co.com.dtech.accesscontrol.common.util.AppLogger;
import co.com.dtech.accesscontrol.modules.parking.model.ParkingRequestBean;
import co.com.dtech.accesscontrol.repository.ParkingHistoryRepository;
import co.com.dtech.accesscontrol.repository.ParkingRepository;
import co.com.dtech.accesscontrol.repository.ParkingReserveRepository;
import co.com.dtech.accesscontrol.repository.StatusRepository;
import co.com.dtech.accesscontrol.repository.TagRepository;
import co.com.dtech.accesscontrol.repository.UserRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ParkingService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private ParkingRepository parkingRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private ParkingReserveRepository reserveRepository;

	@Autowired
	private ParkingHistoryRepository historyRepository;

	public boolean validate(ParkingRequestBean request) {

		Parking parking = parkingRepository.getById(request.getParkingId());

		if (parking == null) {
			return false;
		}

		Tag tag = tagRepository.findByTagCode(request.getTagCode());
		if (tag == null) {
			return false;
		}

		User user = userRepository.findByTags(tag);
		if (user == null) {
			return false;
		}

		ParkingHistory history = new ParkingHistory();
		history.setAction("I");
		history.setActionByGuard("N");
		history.setParking(parking);
		history.setUser(user);

		if ("S".equals(parking.getReserveNeeded())) {
			ParkingReserve reserve = reserveRepository.validateReserve(new Date(), StatusEnum.ACTIVA.getId(),
					parking.getId(), user.getId());
			if (reserve == null) {
				return false;
			}
			reserve.setStatus(statusRepository.getById(StatusEnum.EN_USO.getId()));
			reserve.setInputDate(new Date());
			reserveRepository.save(reserve);
			history.setReserved("S");
			history.setReserve(reserve);
		}else {
			history.setReserved("N");
		}
		historyRepository.save(history);
		return true;
	}

	public void parkingExit(ParkingRequestBean request) {

		Parking parking = parkingRepository.getById(request.getParkingId());

		if (parking == null) {
			
			throw new IllegalArgumentException("No se encuentra parqueadero con el ID: "+ request.getParkingId());
		}

		Tag tag = tagRepository.findByTagCode(request.getTagCode());
		if (tag == null) {
			throw new IllegalArgumentException("No se encuentra tag con el ID: "+ request.getTagCode());
		}

		User user = userRepository.findByTags(tag);
		if (user == null) {
			throw new IllegalArgumentException("No se encuentra usuario asociado al Tag: "+ request.getTagCode());
		}

		ParkingHistory history = new ParkingHistory();
		history.setAction("O");
		history.setActionByGuard("N");
		history.setParking(parking);
		history.setUser(user);

		if ("S".equals(parking.getReserveNeeded())) {
			ParkingReserve reserve = reserveRepository.validateReserve(new Date(), StatusEnum.EN_USO.getId(),
					parking.getId(), user.getId());
			if (reserve == null) {
				throw new IllegalArgumentException("No se reserva en uso para el usuario: "+ user.getNames() + " "+ user.getLastName1());
			}
			reserve.setStatus(statusRepository.getById(StatusEnum.FINALIZADA.getId()));
			reserve.setExitDate(new Date());
			reserveRepository.save(reserve);
			history.setReserved("S");
			history.setReserve(reserve);
		}else {
			history.setReserved("N");
		}
		historyRepository.save(history);
	}

}
