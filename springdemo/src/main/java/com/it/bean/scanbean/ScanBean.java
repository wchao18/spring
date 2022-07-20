package com.it.bean.scanbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@ComponentScan({"com.it","com.it.aop"})
//加载配置文件源码位置：org.springframework.context.annotation.ConfigurationClassParser.processPropertySource
@PropertySource(value = "classpath:application.properties")
public class ScanBean {

    @Bean
    public Lisi lisi(){
        Lisi lisi = new Lisi();
        lisi.setName("李四");
        lisi.setAge(18);
        return lisi;
    }

}
