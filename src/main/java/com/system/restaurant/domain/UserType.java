package com.system.restaurant.domain;

public enum UserType {
    WAITER(1, "waiter"), CHEF(2, "chef"), ADMIN(3, "admin");

    int code;
    String text;
    UserType() {}

    UserType(int i, String r) {
        this.code = i;
        this.text = r;
    }

}
