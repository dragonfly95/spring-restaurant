package com.system.restaurant;


import com.system.restaurant.domain.*;
import lombok.*;
import org.springframework.core.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.support.*;
import org.springframework.web.context.request.*;
import org.springframework.web.method.support.*;

import javax.servlet.http.*;

@Component
@RequiredArgsConstructor
public class MyArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession session;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return UserVO.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        return userVO;
    }
}
