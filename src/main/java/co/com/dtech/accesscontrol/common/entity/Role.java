package co.com.dtech.accesscontrol.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import co.com.dtech.accesscontrol.common.bean.RoleBean;

@Entity
@Table(name = "role")
public class Role extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8625860326800495428L;

	@Column(name = "description")
	private String description;

	@Column(name = "reserve_needed")
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
		return "Role [description=" + description + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

	@Override
	public RoleBean getBean() {
		RoleBean bean = new RoleBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

}
