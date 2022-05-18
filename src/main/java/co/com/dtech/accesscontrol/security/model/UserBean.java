package co.com.dtech.accesscontrol.security.model;

import co.com.dtech.accesscontrol.common.GenericBean;

public class UserBean extends GenericBean {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3011116615486140250L;

	private String names;
	private String lastName1;
	private String lastName2;
	private UserTypeBean userType;
	private String username;
	private String password;
	private String token;
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
	public UserTypeBean getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserTypeBean userType) {
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "UserBean [names=" + names + ", lastName1=" + lastName1 + ", lastName2=" + lastName2 + ", userType="
				+ userType + ", username=" + username + ", password=" + password + ", token=" + token + ", id=" + id
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
