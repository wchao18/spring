package com.it.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJAnnotationConfig {

    @Pointcut("execution(public * com.it.aop.service.*.*(..))")
    private void pc1() {

    }

    @Around("pc1()")//advice
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===================AspectAnnotation around前置通知");
        Object result = joinPoint.proceed();
        System.out.println("===================AspectAnnotation around后置通知");
        return result;
    }

}
