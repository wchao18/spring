package com.it.requiredPropertie;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 测试必备属性
 */
public class RequiredPropertieClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public RequiredPropertieClassPathXmlApplicationContext(String configLocation) throws BeansException {
        super(configLocation);
    }

    @Override
    protected void initPropertySources() {
        ConfigurableEnvironment environment = getEnvironment();
        //要求必须要的属性
        environment.setRequiredProperties("aa", "bb");
    }
}
