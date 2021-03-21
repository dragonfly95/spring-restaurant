package com.system.restaurant.domain;

import lombok.*;

import java.io.*;

@Data
public class UserVO implements Serializable {
    private int userId;
    private String userName;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private UserType userType;

    public UserType getUserType() {
        return UserType.valueOf(userType.name());
    }
}
