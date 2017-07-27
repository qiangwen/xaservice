package com.xa.gtsserver.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 全局事务
 * @author qiang.wen
 * @date 2017年7月27日 下午5:16:34
 */
public class GtsGlobalTransaction implements Serializable{

	private static final long serialVersionUID = 3262526307473375428L;
	
	private int id;//主键
	
	private String gtsId;//全局事务id
	
	private int gtsAppId;//发起全局事务的appId
	
	private int gtsStatus;//全局事务的状态
	
	private int versionNo;//版本号
	
	private Date createTime;//创建时间
	
	private Date updateTime;//更新时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGtsId() {
		return gtsId;
	}

	public void setGtsId(String gtsId) {
		this.gtsId = gtsId;
	}

	public int getGtsAppId() {
		return gtsAppId;
	}

	public void setGtsAppId(int gtsAppId) {
		this.gtsAppId = gtsAppId;
	}

	public int getGtsStatus() {
		return gtsStatus;
	}

	public void setGtsStatus(int gtsStatus) {
		this.gtsStatus = gtsStatus;
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
