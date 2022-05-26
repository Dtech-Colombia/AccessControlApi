package co.com.dtech.accesscontrol.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import co.com.dtech.accesscontrol.common.bean.UserBean;

@Entity
@Table(name = "user")
public class User extends GenericEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 850031124564642483L;

	@Column(name = "names")
	private String names;

	@Column(name = "last_name1")
	private String lastName1;

	@Column(name = "last_name2")
	private String lastName2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type", nullable = false)
	private UserType userType;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToMany
	@JoinTable(name = "user_tags", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

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
	 * @return the lastName1
	 */
	public String getLastName1() {
		return lastName1;
	}

	/**
	 * @param lastName1 the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}

	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "User [names=" + names + ", lastName1=" + lastName1 + ", lastName2=" + lastName2 + ", userType="
				+ userType + ", username=" + username + ", password="
				+ password /*
							 * + ", id=" + id + ", idcreatedAt=" + createdAt + ", updatedAt=" + updatedAt
							 */ + "]";
	}

	@Override
	public UserBean getBean() {
		UserBean bean = new UserBean();
		BeanUtils.copyProperties(this, bean, new String[] { "password" });
		if (this.userType != null) {
			bean.setUserType(this.userType.getBean());
		}
		return bean;

	}

}
