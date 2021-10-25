package com.it.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;

import java.util.Locale;

/**
 * xxxAware什么时候调用的？？
 */
public class AContextAware implements ApplicationContextAware, MessageSource {

    private ApplicationContext applicationContext;

    //利用回调机制
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println();
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return null;
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return null;
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return null;
    }
}
