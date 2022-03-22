package com.it.bean.configurationAnnoBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Component
@Configuration
public class AnnoBean implements AnnoBeanInf {

    /**
     MethodMetadata
     BeanDefinition对象
     factoryBeanName = AnnoBean
     factoryMethodName = li
     son
    */
    @Primary
    @Bean
    public Lison lison() {
        return new Lison();
    }

    /**
     BeanDefinition对象
     factoryBeanName = AnnoBean
     factoryMethodName = lison
    */
    @Bean
    public LisonFactory lisonFactory() throws Exception {
        LisonFactory lisonFactory = new LisonFactory();
        //lison() beanFactory.getBean(id)  缓存里面
        lisonFactory.setLison(this.lison());
        //beanFactory.getBean
        LiLi liLi = this.liLi();
        Object object = liLi.getObject();
        System.out.println("lili getObject : " + object.hashCode());
        liLi.xae();
        return lisonFactory;
    }

    @Bean
    public LiLi liLi() {
        System.out.println("lili的构造方法");
        return new LiLi();
    }

    @Override
    public void xx() {

    }

    @Override
    public void aa() {

    }
}
