package co.com.dtech.accesscontrol.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import co.com.dtech.accesscontrol.common.bean.GenericBean;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4801326732158859548L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Integer id;

	@Column(name = "created_at", insertable = true, updatable = false)
	protected Date createdAt;

	@Column(name = "updated_at", insertable = false, updatable = true)
	protected Date updatedAt;

	
	public abstract GenericBean getBean();
	

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
	 * @return the idcreatedAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param idcreatedAt the idcreatedAt to set
	 */
	public void setCreatedAt(Date idcreatedAt) {
		this.createdAt = idcreatedAt;
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
		return "GenericEntity [id=" + id + ", idcreatedAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
