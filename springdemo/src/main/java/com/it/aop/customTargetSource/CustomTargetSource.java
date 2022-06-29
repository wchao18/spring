package com.it.aop.customTargetSource;

import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;

public class CustomTargetSource extends AbstractBeanFactoryBasedTargetSource {
    @Override
    public Object getTarget() throws Exception {
        //为什么获取的不是代理对象 而是被代理对象？
        //getBeanFactory其实被替换掉了（全新的）,删除掉了原先的aop的BeanPostProcessor
        return getBeanFactory().getBean(getTargetBeanName());
    }
}
