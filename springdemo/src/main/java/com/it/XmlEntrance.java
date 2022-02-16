package com.it;

import com.it.bean.factory.UserFactory;
import com.it.bean.factorybean.User;
import com.it.bean.factorybean.UserFactoryBean;
import com.it.bean.propertiesbean.PropertiesBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlEntrance {

    public static void main(String[] args) {

        System.setProperty("x", "config");
        /*    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring" + "/spring-${x}.xml");
         */

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring-config.xml");
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

        //自定义注解扫描器
        /*CustomBeanClass customScannerBeanClass = classPathXmlApplicationContext.getBean(CustomBeanClass.class);
        System.out.println(customScannerBeanClass);*/

        //bean销毁
        //classPathXmlApplicationContext.getBeanFactory().destroySingletons();

        //配置文件测试
     /*   PropertiesBean propertiesBean = classPathXmlApplicationContext.getBean(PropertiesBean.class);
        System.out.println(propertiesBean.getName());*/

        //factoryBean
        //User user = (User) classPathXmlApplicationContext.getBean("userFactoryBean");

        //多例bean,容器启动不会加载
       /* Object prototypeBeanA = classPathXmlApplicationContext.getBean("prototypeBeanA");
        System.out.println(prototypeBeanA);
        Object prototypeBeanA1 = classPathXmlApplicationContext.getBean("prototypeBeanA");
        System.out.println(prototypeBeanA1);*/

       //自定义scope,容器启动不会加载
        System.out.println(classPathXmlApplicationContext.getBean("customScopeBean"));
    }
}