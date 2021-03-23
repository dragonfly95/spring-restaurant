package com.system.restaurant;

import com.system.restaurant.domain.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.handler.*;

import javax.servlet.http.*;

public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        if (userVO == null) {
            response.sendRedirect("/login.do");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
