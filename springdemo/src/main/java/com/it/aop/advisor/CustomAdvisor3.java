package com.it.aop.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class CustomAdvisor3 implements PointcutAdvisor, Ordered {
    @Override
    public Pointcut getPointcut() {
        return Pointcut.TRUE;
    }

    @Override
    public Advice getAdvice() {
        return new CustomAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
