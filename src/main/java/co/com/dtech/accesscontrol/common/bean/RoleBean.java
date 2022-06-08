package co.com.dtech.accesscontrol.common.bean;

public class RoleBean extends GenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7704326223476376413L;

	private String description;

	private String reserveNeeded;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "RoleBean [description=" + description + ", id=" + id + ", token=" + token + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
