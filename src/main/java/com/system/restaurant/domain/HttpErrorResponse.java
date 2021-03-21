package com.system.restaurant.domain;

import lombok.*;

import java.sql.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpErrorResponse {

    private Integer status;
    private String errorMessage;
    private String timeStamp;

    public HttpErrorResponse(int status, String message) {
        this.setStatus(status);
        this.setErrorMessage(message);
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        this.timeStamp = timestamp1.toString();
    }
}
