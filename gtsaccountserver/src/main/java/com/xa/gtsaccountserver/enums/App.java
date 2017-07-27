package com.xa.gtsaccountserver.enums;

public enum App {

	ORDERSEVER(1),
	ACCOUNTSEVER(2);
	
	private int appId;
	
	private App(int appId){
		this.appId = appId;
	}

	public int getAppId() {
		return appId;
	}
	
}
