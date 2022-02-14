package com.it.bean.circular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试循环依赖问题
 */
@Component
public class CircularRefA {

    public CircularRefA(){
        System.out.println("=======================CircularRefA");
    }

    @Autowired
    private CircularRefB circularRefB;

    @Autowired
    private CircularRefC circularRefC;
}
