package com.xa.gtsorderserver.request.gtsserver;

import com.xa.gtsorderserver.enums.App;

public class GlobalTransactionRequest extends XaRequest {

	private static final long serialVersionUID = -4902495229511397693L;

	private App gtsApp;//发起全局事务的根App

	public App getGtsApp() {
		return gtsApp;
	}

	public void setGtsApp(App gtsApp) {
		this.gtsApp = gtsApp;
	}
	
	
	
}
