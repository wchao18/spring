package com.it;

import com.it.aop.AopConfig;
import com.it.aop.service.AopAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopAnnotationEntrance {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AopConfig.class);

        AopAccountService aopAccountService = annotationConfigApplicationContext.getBean(AopAccountService.class);
        aopAccountService.addAccount(1L,"test");

    }
}
