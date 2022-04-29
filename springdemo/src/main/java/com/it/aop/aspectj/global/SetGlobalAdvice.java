package com.it.aop.aspectj.global;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class SetGlobalAdvice implements BeanPostProcessor, PriorityOrdered {

    @Override
    public int getOrder() {
        return 99999;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof AnnotationAwareAspectJAutoProxyCreator){
            AnnotationAwareAspectJAutoProxyCreator awareAspectJAutoProxyCreator = (AnnotationAwareAspectJAutoProxyCreator) bean;
            awareAspectJAutoProxyCreator.setInterceptorNames("globalAdvice");
        }
        return bean;
    }
}
