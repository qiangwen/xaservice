package com.xa.gtsorderserver.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单
 * @author qiang.wen
 * @date 2017年7月26日 上午10:50:48
 */
public class Order implements Serializable{

	private static final long serialVersionUID = -3305478728247744830L;

	private int id;
	
	private BigDecimal orderMoney;
	
	private int orderUserId;
	
	private int projectId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	public int getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
}
