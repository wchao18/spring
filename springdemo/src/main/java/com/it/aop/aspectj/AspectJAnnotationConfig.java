package com.it.aop.aspectj;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 排序规则
 */
@Component
@Aspect
public class AspectJAnnotationConfig {


    @Pointcut("execution(public * com.it.aop.service.*.*(..))")
    public void pc1() {
    }

    @Before("pc1()")
    public void before(JoinPoint joinPoint) {
        //小技巧：各种方法的参数记不住的情况下，可以用如下的实现
        MethodInvocation methodInvocation = ExposeInvocationInterceptor.currentInvocation();
        System.out.println("开始调用 " + joinPoint);
    }

    @After("pc1()")
    public void after(JoinPoint joinPoint) {
        System.out.println("调用完成 " + joinPoint);
    }

    @Around("pc1()")
    public Object aroundMe(JoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = null;
        System.out.println("开始计时 " + joinPoint);

        returnValue = ((ProceedingJoinPoint) joinPoint).proceed();
        System.out.println("执行成功，结束计时 " + joinPoint);

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时 " + joinPoint + "[" + (endTime - startTime) + "]ms");

        return returnValue;
    }

    @AfterReturning(pointcut = "pc1()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("无论是空还是有值都返回  " + joinPoint + "，返回值[" + returnValue + "]");
    }

    @AfterThrowing(pointcut = "pc1()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("抛出异常通知  " + joinPoint + "   " + exception.getMessage());
    }

    public void testNoAdvise(){

    }

}
