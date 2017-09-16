package com.wrw.eduonline.common.utils;

public class RRException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 错误信息
	 */
	private String msg;
	
	private int code = 500;
	
	public RRException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public RRException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public RRException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
