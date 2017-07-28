package com.xa.gtsserver.request;

import com.xa.gtsserver.enums.App;

public class AppTransactionRequest extends XaRequest {

	
	private static final long serialVersionUID = -8884849124359385550L;

	private App app;//应用app
	
	private String appXid;//应用对应的xid

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public String getAppXid() {
		return appXid;
	}

	public void setAppXid(String appXid) {
		this.appXid = appXid;
	}
	
	
	
}
