package com.it.aware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 注意xml文件中配置了bean
 */
public class AContext {

    private String name;

    /*autowire="byType*/
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("调用set方法设置applicationContext");
        this.applicationContext = applicationContext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println();
        this.name = name;
    }
}
