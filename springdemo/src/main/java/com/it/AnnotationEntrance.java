package com.it;

import com.it.bean.configurationAnnoBean.Docker;
import com.it.bean.configurationAnnoBean.Lison;
import com.it.bean.configurationAnnoBean.LisonFactory;
import com.it.bean.scanbean.ScanBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description 注解启动类
 * @date 2021/08/09 18:18
 */
public class AnnotationEntrance {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ScanBean.class);

        //测试@Configration（cglib代理）
        Lison lison = annotationConfigApplicationContext.getBean("lison", Lison.class);
        System.out.println("lison的hashcode: " + lison.hashCode());
        System.out.println();
        LisonFactory lisonFactory = annotationConfigApplicationContext.getBean(LisonFactory.class);
        System.out.println("lisonFactory的lison的hashcode: " + lisonFactory.getLison().hashCode());

        System.out.println(annotationConfigApplicationContext.getBean(Docker.class).hashCode());


    }
}
