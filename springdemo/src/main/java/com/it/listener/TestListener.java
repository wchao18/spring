package com.it.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangchao
 * @description TODO
 * @date 2022/01/17 15:44
 */
public class TestListener {

    public static void main(String[] args) {
        //测试事件监听器
        ApplicationContext context = new AnnotationConfigApplicationContext(ListenerConfig.class);
                //new ClassPathXmlApplicationContext("classpath*:spring/spring-listener.xml");
        //1、使用spring的多播器发布
       /* ApplicationEventMulticaster applicationEventMulticaster =
                (ApplicationEventMulticaster) context.getBean("applicationEventMulticaster");
        applicationEventMulticaster.multicastEvent(new MessageSourceEvent("测试..."));*/

        //2、手动
        context.publishEvent(new MessageSourceEvent("手动测试"));
        System.out.println("结束");

    }
}
