package co.com.dtech.accesscontrol.common.enums;

public enum RoleEnum {	
	STUDENTD(1),	RECTOR(2);
	
	private int id;

	/**
	 * @param id
	 */
	private RoleEnum(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}	
	
}
