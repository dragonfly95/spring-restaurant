package com.system.restaurant.domain;


import lombok.*;

@Data
public class ResponseVo {
    public static final String OK = "OK";
    private int code;
    private String message;

    public ResponseVo() {}

    public ResponseVo(int i, String m) {
        this.code = i;
        this.message = m;
    }
}
