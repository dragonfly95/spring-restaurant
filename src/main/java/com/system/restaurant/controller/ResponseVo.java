package com.system.restaurant.controller;


public class ResponseVo {
    public static final String OK = "OK";
    private int code;
    private String message;

    public ResponseVo() {}

    public ResponseVo(int i, String m) {
        this.code = i;
        this.message = m;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
