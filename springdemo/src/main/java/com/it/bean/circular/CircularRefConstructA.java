package com.it.bean.circular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class CircularRefConstructA {

    public CircularRefConstructA(CircularRefConstructB circularRefConstructB){

    }
}
