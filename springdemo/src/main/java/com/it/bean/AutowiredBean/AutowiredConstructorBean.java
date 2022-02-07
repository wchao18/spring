package com.it.bean.AutowiredBean;


import com.it.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AutowiredConstructorBean {


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
