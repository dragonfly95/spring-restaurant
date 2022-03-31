package com.system.restaurant.domain;

public enum UserType {
    waiter(1), chef(2), admin(3);

    int code;

    UserType() {}

    UserType(int i) {
        this.code = i;
    }

    public int getCode() {
        return code;
    }
}
