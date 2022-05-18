package co.com.dtech.accesscontrol.security.model;

import co.com.dtech.accesscontrol.common.GenericBean;

public class UserTypeBean extends GenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7294656699972596978L;
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
		return "UserTypeDTO [description=" + description + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
