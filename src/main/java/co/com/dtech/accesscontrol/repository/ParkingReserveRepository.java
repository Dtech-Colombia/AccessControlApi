package co.com.dtech.accesscontrol.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.dtech.accesscontrol.common.entity.ParkingReserve;

@Repository
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public interface ParkingReserveRepository extends JpaRepository<ParkingReserve, Integer> {

	@Query("Select count(id) FROM ParkingReserve where :initial < finalDate AND  :end > initialDate AND status.id = :idStatus AND parking_id = :idParking")
	Integer countActiveReserve(@Param(value = "initial") Date initial,@Param(value = "end") Date end, @Param(value = "idStatus") Integer status,@Param(value = "idParking") Integer parking);

}
