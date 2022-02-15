package com.it.bean.propertiesbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueBean {

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;
}
