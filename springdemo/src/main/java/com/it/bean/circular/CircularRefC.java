package com.it.bean.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularRefC {

    public CircularRefC(){
        System.out.println("=======================CircularRefC");
    }

    @Autowired
    private CircularRefA circularRefA;

    @Autowired
    private CircularRefB circularRefB;
}
