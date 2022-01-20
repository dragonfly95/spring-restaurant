package com.system.restaurant.domain;


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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
