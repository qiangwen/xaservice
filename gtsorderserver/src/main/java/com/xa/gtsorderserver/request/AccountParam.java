package com.xa.gtsorderserver.request;

import java.math.BigDecimal;

public class AccountParam extends XaParam{

	private static final long serialVersionUID = -9190273056603694079L;

	private int userId;
	
	private BigDecimal money;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	
}
