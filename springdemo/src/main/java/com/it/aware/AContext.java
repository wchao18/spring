package com.it.aware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 注意xml文件中配置了bean
 */
public class AContext {

    private String name;

    @Autowired
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //没有set方法也可以！
   /* public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
