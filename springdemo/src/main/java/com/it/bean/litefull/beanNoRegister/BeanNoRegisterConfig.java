package com.it.bean.litefull.beanNoRegister;


import com.it.bean.litefull.fullpkg.FullConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.it.bean.litefull.beanNoRegister")
public class BeanNoRegisterConfig {

    //@Bean生成配置类@Configuration
    @Bean
    public FullConfig fullConfig(){
        System.out.println();
        return new FullConfig();
    }
}
