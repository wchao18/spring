package com.it.aop.scopedproxy;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//这里代理走了切面，每次根据Prototype多例获取的对象是不一样的！
@Scope(value = DefaultListableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScopedProxyBean {

    public void code() {
        System.out.println(this.hashCode());
    }
}
