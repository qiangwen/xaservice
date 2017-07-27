package com.xa.gtsaccountserver.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class XaAccount implements Serializable{
	
	private static final long serialVersionUID = -3168790394241016634L;
	
	private int id;
	
	private int userId;
	
	private BigDecimal avaliableMoney;
	
	private BigDecimal balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BigDecimal getAvaliableMoney() {
		return avaliableMoney;
	}

	public void setAvaliableMoney(BigDecimal avaliableMoney) {
		this.avaliableMoney = avaliableMoney;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	

}
