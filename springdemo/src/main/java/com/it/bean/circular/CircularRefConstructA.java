package com.it.bean.circular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularRefConstructA {

    @Lazy //生成B的cglib代理对象，不走getBean方法
    public CircularRefConstructA(CircularRefConstructB circularRefConstructB){
        System.out.println();

    }
}
