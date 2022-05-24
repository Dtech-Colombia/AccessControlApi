package co.com.dtech.accesscontrol.common.enums;

public enum StatusEnum {	
	ACTIVA(1),	EN_USO(2),	FINALIZADA(3),	EXPIRADA(4);
	
	private int id;

	/**
	 * @param id
	 */
	private StatusEnum(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
	
}
