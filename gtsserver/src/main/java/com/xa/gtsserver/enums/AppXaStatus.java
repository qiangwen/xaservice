package com.xa.gtsserver.enums;

/**
 * 各应用事务提交状态
 * @author qiang.wen
 * @date 2017年7月27日 下午6:43:37
 */
public enum AppXaStatus {

	PREPARED(1),
	COMMITED(2),
	ROLLBACK(3);
	
	private int status;
	
	private AppXaStatus(int status){
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	
}
