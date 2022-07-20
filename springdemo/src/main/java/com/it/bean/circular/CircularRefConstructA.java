package com.it.bean.circular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularRefConstructA {

    private CircularRefConstructB circularRefConstructB;

    @Lazy //生成B的cglib代理对象，不走getBean方法
    public CircularRefConstructA(CircularRefConstructB circularRefConstructB){
        this.circularRefConstructB = circularRefConstructB;
        //注意：构造函数中不能调用方法，可能会存在循环依赖问题
        System.out.println();

    }

    public CircularRefConstructB getCircularRefConstructB() {
        return circularRefConstructB;
    }

    public void getA(){

    }
}
