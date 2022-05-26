package co.com.dtech.accesscontrol.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import co.com.dtech.accesscontrol.common.bean.GenericBean;

@Entity
@Table(name = "tag")
public class Tag extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8861934410407209414L;

	@Column(name = "tag_code")
	private String tagCode;

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
	public GenericBean getBean() {
		// TODO Auto-generated method stub
		return null;
	}

}
