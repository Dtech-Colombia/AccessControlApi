package co.com.dtech.accesscontrol.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import co.com.dtech.accesscontrol.common.bean.StatusBean;

@Entity
@Table(name = "status")
public class Status extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8625860326800495428L;

	@Column(name = "description")
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
		return "Status [description=" + description + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

	@Override
	public StatusBean getBean() {
		StatusBean bean = new StatusBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

}
