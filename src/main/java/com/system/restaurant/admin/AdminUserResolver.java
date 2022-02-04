package com.system.restaurant.admin;

import com.system.restaurant.ValidCustomException;
import com.system.restaurant.domain.AdminUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class AdminUserResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return AdminUser.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Object admin = webRequest.getAttribute("admin", WebRequest.SCOPE_SESSION);
        if (admin == null) {
            // login session null exception
            throw new ValidCustomException("로그인 해주세요");
        }
        return admin;
    }
}
