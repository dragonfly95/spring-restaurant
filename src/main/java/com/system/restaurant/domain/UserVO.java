package com.system.restaurant.domain;


import lombok.*;

@Data
public class UserVO {
    private int userId;
    private String userName;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private UserType userTye;

}
