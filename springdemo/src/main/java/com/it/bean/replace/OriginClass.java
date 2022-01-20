package com.it.bean.replace;

import java.util.List;

public class OriginClass {

    //对这个方法业务增强
    public void method(String param) {
        System.out.println("origin class method");
    }

    public void method(List param) {
        System.out.println("origin class method");
    }
}
