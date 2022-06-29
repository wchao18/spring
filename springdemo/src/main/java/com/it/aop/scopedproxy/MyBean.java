package com.it.aop.scopedproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Autowired
    private ScopedProxyBean scopedProxyBean;//原生对象注入只有一次，注入后就不会变了，为什么是代理？

    public void tet() {
        scopedProxyBean.code();
    }
}
