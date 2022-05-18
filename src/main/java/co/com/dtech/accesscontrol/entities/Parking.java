package co.com.dtech.accesscontrol.entities;

import javax.persistence.Column;

import co.com.dtech.accesscontrol.common.GenericBean;

public class Parking extends GenericEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8359330660563047337L;
	
	@Column(name = "names")
	private String names;
	
	@Column(name = "reserve_needed")
	private String reserveNeeded;
	
	@Column(name = "total_available")
	private Integer totalAvailable;
	
	@Column(name = "reversed_lots")
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
		return "Parking [names=" + names + ", reserveNeeded=" + reserveNeeded + ", totalAvailable=" + totalAvailable
				+ ", reservedLots=" + reservedLots + "]";
	}

	@Override
	public GenericBean getBean() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
