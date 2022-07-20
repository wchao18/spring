package com.it.bean.sameBeanName;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("b")
public class BeanNameSame {


    @Bean
    public BeanName beanName(Object o){
        System.out.println("===========beanSame");
        return new BeanName();
    }


    @Bean
    public BeanName beanName(){
        return new BeanName();
    }


}
