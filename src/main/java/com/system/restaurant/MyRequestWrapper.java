package com.system.restaurant;

import javax.servlet.http.*;

public class MyRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletResponse response;

    public void setResponse(final HttpServletResponse response) {
        this.response = response;
    }

    public MyRequestWrapper(HttpServletRequest request) {
        super(request);
    }
}