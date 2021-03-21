package com.system.restaurant.domain;

import lombok.*;

@Data
public class UserVO {
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
