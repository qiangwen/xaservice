package com.xa.gtsserver.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 各应用参与的事务
 * @author qiang.wen
 * @date 2017年7月27日 下午6:17:32
 */
public class GtsAppTransaction implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;//主键id
	
	private int globalTransactionId;//全局事务id 对应 gts_global_transaction.id
	
	private int appId;//参与服务id
	
	private String appXid;//对应应用的事务id 由 gtrid:bqual:formatId 组成
	
	private int xaStatus;//事务状态 1:prepared,2:commited,3:rollback
	
	private int versionNo;//版本号
	
	private Date createTime;//创建时间
	
	private Date updateTime;//更新时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGlobalTransactionId() {
		return globalTransactionId;
	}

	public void setGlobalTransactionId(int globalTransactionId) {
		this.globalTransactionId = globalTransactionId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppXid() {
		return appXid;
	}

	public void setAppXid(String appXid) {
		this.appXid = appXid;
	}

	public int getXaStatus() {
		return xaStatus;
	}

	public void setXaStatus(int xaStatus) {
		this.xaStatus = xaStatus;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	

}
