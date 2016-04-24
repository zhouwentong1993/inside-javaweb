package com.puhui.demo.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by wentong on 2016/4/24.
 * Spring boot 的面向切面编程。
 */
@Aspect
@Component
public class ServiceMonitor {
    @AfterReturning("execution(* com.puhui..*Service.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }
}
