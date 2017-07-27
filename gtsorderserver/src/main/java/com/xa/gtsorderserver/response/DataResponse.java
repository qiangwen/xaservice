package com.xa.gtsorderserver.response;

import java.io.Serializable;

public class DataResponse<T> implements Serializable{

	private static final long serialVersionUID = 1847113571276982610L;

	private int retcode;
	
	private String msg;
	
	private T data;

	public int getRetcode() {
		return retcode;
	}

	public DataResponse<T> setRetcode(int retcode) {
		this.retcode = retcode;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public DataResponse<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public DataResponse<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	public static <T> DataResponse<T> build(){
		DataResponse<T> dataResponse = new DataResponse<>();
		return dataResponse;
	}
	
}
