package com.it.bean.propertiesbean;


import org.springframework.stereotype.Component;

/**
 * xml中设置属性值
 */
public class PropertiesBean {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println();
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
