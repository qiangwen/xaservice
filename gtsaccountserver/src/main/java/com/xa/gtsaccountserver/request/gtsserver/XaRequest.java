package com.xa.gtsaccountserver.request.gtsserver;

import java.io.Serializable;

public class XaRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String gtsId;//全局事务id

	public String getGtsId() {
		return gtsId;
	}

	public void setGtsId(String gtsId) {
		this.gtsId = gtsId;
	}
	
	

}
