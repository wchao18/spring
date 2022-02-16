package com.it.bean.propertiesbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ValueBean implements EnvironmentAware {

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println(environment.getProperty("my2022"));
    }
}
