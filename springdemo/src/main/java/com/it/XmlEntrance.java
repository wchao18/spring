package com.it;

import com.it.aware.AContext;
import com.it.aware.AContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.testIgnore.IgnoreOther;
import org.springframework.testIgnore.PoJoA;

import java.util.Arrays;

public class XmlEntrance {

    public static void main(String[] args) {

       /* ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring" +
                "/spring-config.xml");*/
        System.setProperty("x", "config");
    /*    ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring" + "/spring-${x}.xml");
*/

        new ClassPathXmlApplicationContext("spring/spring-processor.xml");

        //测试刷新
       /* try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        classPathXmlApplicationContext.refresh();*/


        /*Ignore测试*/
      /*  IgnoreOther ignoreOtherByType = (IgnoreOther) classPathXmlApplicationContext.getBean("IgnoreOtherByType");
        System.out.println(ignoreOtherByType);
        //
        IgnoreOther ignoreOtherByName = (IgnoreOther) classPathXmlApplicationContext.getBean("IgnoreOtherByName");
        System.out.println(ignoreOtherByName);
        //
        IgnoreOther ignoreOtherByConstructor = (IgnoreOther) classPathXmlApplicationContext.getBean(
                "IgnoreOtherByConstructor");
        System.out.println(ignoreOtherByConstructor);*/


        /*JavaConfig*/
        /*AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Entrance.class);*/

        //测试获取bean中的容器对象
       /* AContext aContext = classPathXmlApplicationContext.getBean(AContext.class);

        AContextAware aContextAware = classPathXmlApplicationContext.getBean(AContextAware.class);
        System.out.println("容器：" + aContext.getApplicationContext());
        System.out.println("容器：" + aContextAware.getApplicationContext());*/
    }
}
