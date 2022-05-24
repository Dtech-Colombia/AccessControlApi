package co.com.dtech.accesscontrol.common.bean;

public class ParkingBean extends GenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5330537984175499752L;

	private String names;

	private String reserveNeeded;

	private Integer totalAvailable;

	private Integer reservedLots;

	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the reserveNeeded
	 */
	public String getReserveNeeded() {
		return reserveNeeded;
	}

	/**
	 * @param reserveNeeded the reserveNeeded to set
	 */
	public void setReserveNeeded(String reserveNeeded) {
		this.reserveNeeded = reserveNeeded;
	}

	/**
	 * @return the totalAvailable
	 */
	public Integer getTotalAvailable() {
		return totalAvailable;
	}

	/**
	 * @param totalAvailable the totalAvailable to set
	 */
	public void setTotalAvailable(Integer totalAvailable) {
		this.totalAvailable = totalAvailable;
	}

	/**
	 * @return the reservedLots
	 */
	public Integer getReservedLots() {
		return reservedLots;
	}

	/**
	 * @param reservedLots the reservedLots to set
	 */
	public void setReservedLots(Integer reservedLots) {
		this.reservedLots = reservedLots;
	}

	@Override
	public String toString() {
		return "ParkingBean [names=" + names + ", reserveNeeded=" + reserveNeeded + ", totalAvailable=" + totalAvailable
				+ ", reservedLots=" + reservedLots + ", id=" + id + ", token=" + token + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}



}
