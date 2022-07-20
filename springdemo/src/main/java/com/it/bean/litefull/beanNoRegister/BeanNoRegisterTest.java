package com.it.bean.litefull.beanNoRegister;

import com.it.bean.litefull.LiteFullUser;
import com.it.bean.litefull.fullpkg.FullConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanNoRegisterTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanNoRegisterConfig.class);
        System.out.println(context.getBean(FullConfig.class));
        //理论上可以获取到LiteFullUser,实际上没有获取到
        LiteFullUser bean = context.getBean(LiteFullUser.class);
    }
}
