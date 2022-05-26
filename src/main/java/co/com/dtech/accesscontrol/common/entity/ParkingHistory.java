package co.com.dtech.accesscontrol.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.dtech.accesscontrol.common.bean.GenericBean;

@Entity
@Table(name = "parking_history")
public class ParkingHistory extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3491244564213449088L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parking_id", nullable = false)
	private Parking parking;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "action")
	private String action;

	@Column(name = "reserved")
	private String reserved;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reserve_id", nullable = true)
	private ParkingReserve reserve;

	@Column(name = "action_by_guard")
	private String actionByGuard;

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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the reserved
	 */
	public String getReserved() {
		return reserved;
	}

	/**
	 * @param reserved the reserved to set
	 */
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	/**
	 * @return the reserve
	 */
	public ParkingReserve getReserve() {
		return reserve;
	}

	/**
	 * @param reserve the reserve to set
	 */
	public void setReserve(ParkingReserve reserve) {
		this.reserve = reserve;
	}

	/**
	 * @return the actionByGuard
	 */
	public String getActionByGuard() {
		return actionByGuard;
	}

	/**
	 * @param actionByGuard the actionByGuard to set
	 */
	public void setActionByGuard(String actionByGuard) {
		this.actionByGuard = actionByGuard;
	}

	@Override
	public GenericBean getBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "ParkingHistory [parking=" + parking + ", user=" + user + ", action=" + action + ", reserved=" + reserved
				+ ", reserve=" + reserve + ", actionByGuard=" + actionByGuard + ", id=" + id + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
