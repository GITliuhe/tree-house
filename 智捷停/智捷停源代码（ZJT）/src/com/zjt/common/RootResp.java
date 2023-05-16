package com.zjt.common;

public class RootResp {
	private Object data;
	private int ret;
	private String msg;

	public int getRet() {
		return this.ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}


	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
