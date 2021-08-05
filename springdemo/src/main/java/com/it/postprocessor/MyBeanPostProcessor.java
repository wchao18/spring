package com.it.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author wangchao
 * @description TODO
 * @date 2021/07/13 17:14
 */
public class MyBeanPostProcessor {

    public static class MyBeanPostProcessor1 implements BeanPostProcessor, Ordered {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("-------------postProcessBeforeInitialization1 start-------------");
            System.out.println("bean: " + bean);
            System.out.println("beanName: " + beanName);
            //如果返回null，则不会调用后续的后置处理器对应的方法
            System.out.println("-------------postProcessBeforeInitialization1 end-------------");
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("-------------postProcessAfterInitialization1 start-------------");
            System.out.println("bean: " + bean);
            System.out.println("beanName: " + beanName);
            System.out.println("-------------postProcessAfterInitialization1 end-------------");
            return bean;
        }

        @Override
        public int getOrder() {
            //数字越小级别越高
            return 0;
        }
    }

    public static class MyBeanPostProcessor2 implements BeanPostProcessor, Ordered {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("-------------postProcessBeforeInitialization2 start-------------");
            System.out.println("bean: " + bean);
            System.out.println("beanName: " + beanName);
            System.out.println("-------------postProcessBeforeInitialization2 end-------------");
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("-------------postProcessAfterInitialization2 start-------------");
            System.out.println("bean: " + bean);
            System.out.println("beanName: " + beanName);
            System.out.println("-------------postProcessAfterInitialization2 end-------------");
            return bean;
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }
}
