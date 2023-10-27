package com.library_manager.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AspectLog {
    @Pointcut("within(com.library_manager.controller.*)")
    public void allMethodPointcut() {

    }
    @Before("allMethodPointcut()")
    public void logMethodInit(JoinPoint joinPoint) {
        System.out.println("Start method: " + joinPoint.getSignature().getName() + " "
        + "Time: " + LocalDateTime.now());
    }
    @AfterReturning("allMethodPointcut()")
    public void logMethodEnd(JoinPoint joinPoint) {
        System.out.println("End method: " + joinPoint.getSignature().getName() + " "
        + "Time: " + LocalDateTime.now());
    }
}
