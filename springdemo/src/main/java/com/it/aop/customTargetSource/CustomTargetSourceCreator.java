package com.it.aop.customTargetSource;

import com.it.aop.service.impl.AopAccountServiceImpl;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryBasedTargetSourceCreator;
import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//@Component
public class CustomTargetSourceCreator extends AbstractBeanFactoryBasedTargetSourceCreator {

    @Override
    protected AbstractBeanFactoryBasedTargetSource createBeanFactoryBasedTargetSource(Class<?> beanClass, String beanName) {
        if (getBeanFactory() instanceof ConfigurableListableBeanFactory) {
            if(beanClass.isAssignableFrom(AopAccountServiceImpl.class)) {
                return new CustomTargetSource();
            }
        }
        return null;
    }
}
