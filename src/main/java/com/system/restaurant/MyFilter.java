package com.system.restaurant;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("=======filter-------------");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        boolean apply = true;
        if(apply) {
            MyRequestWrapper myRequest = new MyRequestWrapper((HttpServletRequest) request);
            myRequest.setResponse(res);
            chain.doFilter(myRequest, response);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.do");
            requestDispatcher.forward(req, res);
        }
//        res.sendError(500, "error message");
//        res.sendRedirect("login.do");
    }

    @Override
    public void destroy() {

    }
}