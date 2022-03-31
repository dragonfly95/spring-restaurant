package com.system.restaurant;


import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@Aspect
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogDate)")
    public Object LogDate(ProceedingJoinPoint joinPoint) throws Throwable {
        Date date = new Date();
        date.getTime();

        Object proceed = joinPoint.proceed();
        logger.info(date.toString());
        return proceed;
    }
}
