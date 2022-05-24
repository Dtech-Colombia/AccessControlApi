package co.com.dtech.accesscontrol.common.bean;

public class StatusBean extends GenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7704326223476376413L;

	private String description;

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

	@Override
	public String toString() {
		return "StatusBean [description=" + description + ", id=" + id + ", token=" + token + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
