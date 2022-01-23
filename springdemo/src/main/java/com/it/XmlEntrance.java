package com.it;

import com.it.aware.AContext;
import com.it.aware.AContextAware;
import com.it.bean.User;
import com.it.bean.lookup.AbstractPeople;
import com.it.bean.lookup.People;
import com.it.bean.replace.OriginClass;
import com.it.postprocessor.factory.annotation.CustomBeanClass;
import com.it.listener.MessageSourceEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ApplicationEventMulticaster;
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

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring-processor.xml");
        //new ClassPathXmlApplicationContext("spring/spring-processor.xml");

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

        //测试工厂bean
        //User bean = classPathXmlApplicationContext.getBean(User.class);

        //测试looup-method-动态代理
        /*AbstractPeople people = (AbstractPeople)classPathXmlApplicationContext.getBean("people");
        people.say();*/

        //测试replace-method
       /* OriginClass originClass = (OriginClass)classPathXmlApplicationContext.getBean("originClass");
        originClass.method("");*/

        CustomBeanClass customScannerBeanClass = classPathXmlApplicationContext.getBean(CustomBeanClass.class);
        System.out.println(customScannerBeanClass);

    }
}
