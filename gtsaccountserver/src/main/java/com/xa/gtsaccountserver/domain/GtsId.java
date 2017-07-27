package com.xa.gtsaccountserver.domain;

import java.io.Serializable;

public class GtsId implements Serializable{

	private static final long serialVersionUID = 1L;

	private String gtsId;
	
	private String bequalId;
	
	private int formatId;
	
	public GtsId(String gtsId,String bequalId,int formatId){
		this.gtsId = gtsId;
		this.bequalId = bequalId;
		this.formatId = formatId;
	}
	
	public GtsId(){}

	public String getGtsId() {
		return gtsId;
	}

	public void setGtsId(String gtsId) {
		this.gtsId = gtsId;
	}

	public String getBequalId() {
		return bequalId;
	}

	public void setBequalId(String bequalId) {
		this.bequalId = bequalId;
	}

	public int getFormatId() {
		return formatId;
	}

	public void setFormatId(int formatId) {
		this.formatId = formatId;
	}
	
	
}
