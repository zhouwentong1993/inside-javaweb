package com.puhui.demo.monitor;

import com.puhui.demo.vo.RestfulUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wentong on 2016/4/24.
 * Spring boot 的面向切面编程。
 */
@Aspect
@Component
public class ServiceMonitor {
//    @AfterReturning("execution(* com.puhui..*Service.*(..))")
//    public void logServiceAccess(JoinPoint joinPoint) {
//        System.out.println("Completed: " + joinPoint);
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    public void requestMapping() {}
    /*
     * 定义一个切入点
     */
@Pointcut("execution(* com.puhui.demo.service..*Impl.*(..))")
public void executeService(){}
    /*
     * 通过连接点切入
     */
    @Before("execution(* getUserById*(..)) &&" + "args(id,..)")
    public void twiceAsOld1(Long id){
        System.err.println ("切面before执行了。。。。id==" + id);

    }

    @Around("executeService()")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint){
        System.err.println ("切面执行了。。。。");
        try {
            RestfulUser thing = (RestfulUser) thisJoinPoint.proceed ();
            thing.setName (thing.getName () + "=========");
            return thing;
        } catch (Throwable e) {
            e.printStackTrace ();
        }
        return null;
    }
}
