package com.imooc;

import com.imooc.aspect.OutSide;
import com.imooc.controller.HelloController;
import com.imooc.controller.HiController;
import com.imooc.controller.WelcomeController;
import com.imooc.dao.impl.Company;
import com.imooc.entity.User;
import com.imooc.entity.factory.UserFactoryBean;
import com.imooc.introduction.LittleUniverse;
import com.imooc.service.HelloService;
import com.imooc.service.HiService;
import com.imooc.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAspectJAutoProxy
@Import(OutSide.class)
@ComponentScan("com.imooc")
public class Entrance {

	public static void main(String[] args) {

       /* ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring" +
                "/spring-config.xml");*/
        System.setProperty("x","config");
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring" + "/spring-${x}.xml");
        classPathXmlApplicationContext.refresh();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        classPathXmlApplicationContext.refresh();


        Arrays.stream(classPathXmlApplicationContext.getBeanDefinitionNames()).forEach(
                s-> System.out.println(s)
        );

		/*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		HiService hiService = (HiService)applicationContext.getBean("hiServiceImpl");
		hiService.sayHi();
		System.out.println("---------------------------分割线以下执行HelloService-------------------------------");
		HelloService helloService = (HelloService)applicationContext.getBean("helloServiceImpl");
		helloService.sayHello();*/
	}
}
