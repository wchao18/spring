package com.it.postprocessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @description TODO
 * @date 2021/08/09 18:07
 */
@Component
public class TestBeanProcessor {

    private String name;

    public TestBeanProcessor() {
        System.out.println("*************** TestBeanProcessor");
    }

    public String getName() {
        return name;
    }

    @Value("${JAVA_HOME}")
    public void setName(String name) {
        System.out.println("TestBeanProcessor自动赋值");
        this.name = name;
    }
}
