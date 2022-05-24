package co.com.dtech.accesscontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.dtech.accesscontrol.common.entity.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
	
	List<Parking> findAllByReserveNeeded(String reserveNeeded);

}
