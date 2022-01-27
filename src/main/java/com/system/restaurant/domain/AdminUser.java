package com.system.restaurant.domain;

public class AdminUser {

    private String role;

    public AdminUser() {}

    public AdminUser(String developer) {
        this.role = developer;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
