package com.xa.gtsorderserver.request.account;

import java.io.Serializable;

import com.xa.gtsorderserver.domain.GtsId;

public class XaParam implements Serializable{

	private static final long serialVersionUID = -3449615148707197433L;
	
	private GtsId gtsId;

	public GtsId getGtsId() {
		return gtsId;
	}

	public void setGtsId(GtsId gtsId) {
		this.gtsId = gtsId;
	}
	
	
	
	

}
