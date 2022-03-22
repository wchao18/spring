package com.it.bean.innerclass;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InnerClassDemo {

    @Component
    public class SpringSouce {

        @Bean
        public Student student() {
            return new Student();
        }

    }

    @Component
    public class Mybatis {

    }
}
