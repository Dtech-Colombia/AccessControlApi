package co.com.dtech.accesscontrol.security.model;

import co.com.dtech.accesscontrol.common.bean.GenericBean;

public class UserTypeBean extends GenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7294656699972596978L;
	private String description;

	/**
	 * 
	 */
	public UserTypeBean() {
		super();
	}

	/**
	 * @param description
	 */
	public UserTypeBean(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

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
		return "UserTypeBean [description=" + description + ", id=" + id + ", token=" + token + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}



}
