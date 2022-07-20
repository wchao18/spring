package com.it.bean.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularRefConstructB {

    private CircularRefConstructA circularRefConstructA;

    @Lazy
    public CircularRefConstructB(CircularRefConstructA circularRefConstructA){
        this.circularRefConstructA = circularRefConstructA;
        System.out.println();
    }

}
