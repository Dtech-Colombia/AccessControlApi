package co.com.dtech.accesscontrol.common;

import java.io.Serializable;
import java.util.Date;

public class GenericBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2172247870667116767L;
	protected Integer id;
	protected Date createdAt;
	protected Date updatedAt;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "GenericBean [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
