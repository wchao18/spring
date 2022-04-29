package com.it.aop.aspectj.global;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 只要调用代理方法，就调用全局Advice
 */
@Component
public class GlobalAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("=======GlobalAdvice.invoke");
        return invocation.proceed();
    }
}
