package co.com.dtech.accesscontrol.common.bean;

import java.util.Date;

public class ParkingReserveBean extends GenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2343242724855263441L;

	private ParkingBean parking;
	private UserBean user;
	private StatusBean status;
	private Date initialDate;
	private Date finalDate;
	private Date expirationDate;
	private Date inputDate;
	private Date exitDate;
	
	/**
	 * @return the parking
	 */
	public ParkingBean getParking() {
		return parking;
	}

	/**
	 * @param parking the parking to set
	 */
	public void setParking(ParkingBean parking) {
		this.parking = parking;
	}

	/**
	 * @return the user
	 */
	public UserBean getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserBean user) {
		this.user = user;
	}

	/**
	 * @return the status
	 */
	public StatusBean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusBean status) {
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
		return "ParkingReserveBean [parking=" + parking + ", user=" + user + ", status=" + status + ", initialDate="
				+ initialDate + ", finalDate=" + finalDate + ", expirationDate=" + expirationDate + ", inputDate="
				+ inputDate + ", exitDate=" + exitDate + ", id=" + id + ", token=" + token + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	

}