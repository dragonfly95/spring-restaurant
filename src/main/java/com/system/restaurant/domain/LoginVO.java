package com.system.restaurant.domain;


import lombok.*;

import java.io.*;

@Data
public class LoginVO implements Serializable {

    private String userLogin;
    private String userPassword;
}
