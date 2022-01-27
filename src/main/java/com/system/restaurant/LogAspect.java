package com.system.restaurant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class LogAspect {

//    @Around("execution(* com.system.restaurant..*.*())")
    @Around("@annotation(LogGetDate)")
    public Object LogGetDate(ProceedingJoinPoint joinPoint) throws Throwable {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("LogAspect time = " + time);

        Object ret = joinPoint.proceed();

        return ret;
    }
}
