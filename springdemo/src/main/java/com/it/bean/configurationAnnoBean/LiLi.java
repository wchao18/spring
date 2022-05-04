package com.it.bean.configurationAnnoBean;

import org.springframework.beans.factory.FactoryBean;

public class LiLi implements FactoryBean<Object> {
    @Override
    public Object getObject() throws Exception {
        return new Docker();
    }

    @Override
    public Class<?> getObjectType() {
        return Docker.class;
    }

    public void xae() {
        System.out.println("xae");
    }
}
