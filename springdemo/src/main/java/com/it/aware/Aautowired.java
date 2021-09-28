package com.it.aware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author wangchao
 * @description TODO
 * @date 2021/08/05 18:28
 */
public class Aautowired {

    private ApplicationContext applicationContext;

    private String name;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //要加context:component-scan 扫描自动装配
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("autowired设置自动装配");
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
