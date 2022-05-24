package co.com.dtech.accesscontrol.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import co.com.dtech.accesscontrol.common.bean.UserTypeBean;

@Entity
@Table(name = "user_type")
public class UserType extends GenericEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1313880946491261225L;

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
		return "UserType [description=" + description + ", id=" + id + ", idcreatedAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

	@Override
	public UserTypeBean getBean() {
		UserTypeBean bean = new UserTypeBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
		
	}
	
	
	

}
