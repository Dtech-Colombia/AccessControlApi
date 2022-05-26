package co.com.dtech.accesscontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.dtech.accesscontrol.common.entity.Parking;

@Repository
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
	
	List<Parking> findAllByReserveNeeded(String reserveNeeded);

}
