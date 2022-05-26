package co.com.dtech.accesscontrol.modules.parking.model;

import java.io.Serializable;

public class parkingValidationRequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1476245935860117249L;

	private Integer parkingId;

	private String tagCode;

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
	 * @return the tagCode
	 */
	public String getTagCode() {
		return tagCode;
	}

	/**
	 * @param tagCode the tagCode to set
	 */
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	@Override
	public String toString() {
		return "parkingValidationRequestBean [parkingId=" + parkingId + ", tagCode=" + tagCode + "]";
	}

}
