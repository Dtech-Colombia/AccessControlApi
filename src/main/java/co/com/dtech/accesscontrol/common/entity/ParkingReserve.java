package co.com.dtech.accesscontrol.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import co.com.dtech.accesscontrol.common.bean.ParkingReserveBean;

@Entity
@Table(name = "parking_reserve")
public class ParkingReserve extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4635006227736887647L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parking_id", nullable = false)
	private Parking parking;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;

	@Column(name = "initial_date")
	private Date initialDate;

	@Column(name = "final_date")
	private Date finalDate;

	@Column(name = "expiration_date")
	private Date expirationDate;

	@Column(name = "input_date")
	private Date inputDate;

	@Column(name = "exit_date")
	private Date exitDate;

	/**
	 * @return the parking
	 */
	public Parking getParking() {
		return parking;
	}

	/**
	 * @param parking the parking to set
	 */
	public void setParking(Parking parking) {
		this.parking = parking;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the initialDate
	 */
	public Date getInitialDate() {
		return initialDate;
	}

	/**
	 * @param initialDate the initialDate to set
	 */
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	/**
	 * @return the finalDate
	 */
	public Date getFinalDate() {
		return finalDate;
	}

	/**
	 * @param finalDate the finalDate to set
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the inputDate
	 */
	public Date getInputDate() {
		return inputDate;
	}

	/**
	 * @param inputDate the inputDate to set
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * @return the exitDate
	 */
	public Date getExitDate() {
		return exitDate;
	}

	/**
	 * @param exitDate the exitDate to set
	 */
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}
	
	

	@Override
	public String toString() {
		return "ParkingReserve [parking=" + parking + ", user=" + user + ", status=" + status + ", initialDate="
				+ initialDate + ", finalDate=" + finalDate + ", expirationDate=" + expirationDate + ", inputDate="
				+ inputDate + ", exitDate=" + exitDate + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

	@Override
	public ParkingReserveBean getBean() {
		ParkingReserveBean bean = new ParkingReserveBean();
		BeanUtils.copyProperties(this, bean,new String[]{"password"});
		if (this.parking!= null) {
			bean.setParking(this.parking.getBean());
		}
		if (this.user!= null) {
			bean.setUser(this.user.getBean());
		}
		if (this.status != null) {
			bean.setStatus(this.status.getBean());
		}
		return bean;
	}

}
