package com.system.restaurant;

public class ResponseVO {

    private String msg;
    private int count;

    public ResponseVO() {
    }

    public ResponseVO(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
