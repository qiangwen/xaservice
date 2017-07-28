package com.xa.gtsserver.enums;

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
	
	public static App getApp(int appId){
		for(App app : App.values()){
			if(app.getAppId() == appId){
				return app;
			}
		}
		return null;
	}
	
}
