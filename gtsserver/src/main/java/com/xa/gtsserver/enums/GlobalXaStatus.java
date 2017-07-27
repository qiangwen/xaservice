package com.xa.gtsserver.enums;

/**
 * 全局事务提交状态
 * @author qiang.wen
 * @date 2017年7月27日 下午6:40:13
 */
public enum GlobalXaStatus {

	NOCOMMITED(1),
	COMMITED(2),
	ROLLBACK(3);
	
	private int status;
	
	private GlobalXaStatus(int status){
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	
}
