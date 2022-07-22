package com.it.bean.litefull;

import com.it.bean.litefull.fullpkg.FullConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.it.bean.litefull")
public class LiteFullAnnotationEntrance {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(LiteFullAnnotationEntrance.class);
        //配置类情况
        System.out.println(context.getBean(FullConfig.class).getClass());
        System.out.println(context.getBean(FullConfig.class).getClass().getSuperclass() == FullConfig.class);//true
        System.out.println(context.getBean(FullConfig.InnerConfig.class).getClass());

        String[] beanNames = context.getBeanNamesForType(LiteFullUser.class);
        for (String beanName : beanNames) {
            LiteFullUser user = context.getBean(beanName, LiteFullUser.class);
            System.out.println("beanName:" + beanName);
            System.out.println(user.getClass());
            System.out.println(user);
            System.out.println("------------------------");
        }
    }
}
