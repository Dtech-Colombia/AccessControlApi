package co.com.dtech.accesscontrol.modules.parking.controller;

import java.io.Serializable;

public class parkingValidationRequestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1476245935860117249L;
	
	private Integer parkingId;
	
	private String tagId;

	/**
	 * @return the parkingId
	 */
	public Integer getParkingId() {
		return parkingId;
	}

	/**
	 * @param parkingId the parkingId to set
	 */
	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	/**
	 * @return the tagId
	 */
	public String getTagId() {
		return tagId;
	}

	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	@Override
	public String toString() {
		return "parkingValidationRequestBean [parkingId=" + parkingId + ", tagId=" + tagId + "]";
	}
	
	

}
