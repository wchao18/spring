package com.it.aop.customTargetSource;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class SetCustomTargetSourceCreator implements BeanPostProcessor, PriorityOrdered, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public int getOrder() {
        return 45;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof AnnotationAwareAspectJAutoProxyCreator) {
            AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator = (AnnotationAwareAspectJAutoProxyCreator)bean;
            CustomTargetSourceCreator customTargetSourceCreator = new CustomTargetSourceCreator();
            customTargetSourceCreator.setBeanFactory(beanFactory);
            annotationAwareAspectJAutoProxyCreator.setCustomTargetSourceCreators(customTargetSourceCreator);
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
