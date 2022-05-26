package co.com.dtech.accesscontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.dtech.accesscontrol.common.entity.ParkingHistory;

public interface ParkingHistoryRepository extends JpaRepository<ParkingHistory, Integer> {

}
