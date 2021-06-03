package com.imooc.requiredPropertie;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangchao
 * @description TODO
 * @date 2021/06/03 9:46
 */
public class RequiredPropertiesTest {

    public static void main(String[] args) {
        System.setProperty("aa","value");
        System.setProperty("bb","value");
        ClassPathXmlApplicationContext requiredPropertieClassPathXmlApplicationContext =
                new RequiredPropertieClassPathXmlApplicationContext("spring/spring-config.xml");
    }
}
