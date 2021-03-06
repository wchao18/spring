package com.it.bean.AutowiredBean;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AutowiredConstructorBean {

    //测试Autowired的后置处理器
    @Resource
    private TrigerClass trigerClass;


    //带头Autowired的构造方法
    //下面两个required都为true报错 @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.determineCandidateConstructors
    //@Autowired(required = false)
    public AutowiredConstructorBean(AutowiredBeanClass autowiredBeanClass){
        System.out.println("Autowired的AutowiredBeanClass构造方法");
    }


    //@Autowired(required = true)
    public AutowiredConstructorBean(){
        System.out.println("Autowired的无参构造方法");
    }

}
