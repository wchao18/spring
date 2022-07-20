package com.it.bean.litefull.fullpkg;

import com.it.bean.litefull.LiteFullUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FullConfig {

    public FullConfig(){
        System.out.println("FullConfig的构造函数");
    }

    @Bean
    public LiteFullUser user() {
        LiteFullUser user = new LiteFullUser();
        user.setName("A哥-lite");
        user.setAge(18);
        return user;
    }


    //注意是final报错,修饰符可以是protected
    @Bean
    protected LiteFullUser user2() {
        LiteFullUser user = new LiteFullUser();
        user.setName("A哥-lite2");
        user.setAge(18);
        // 模拟依赖于user实例  看看是否是同一实例
        System.out.println("hashcode1: " + System.identityHashCode(user()));
        System.out.println("hashcode2: " + System.identityHashCode(user()));
        return user;
    }

    public static class InnerConfig {

        @Bean
        // private final User userInner() { // 只在lite模式下才好使
        private LiteFullUser userInner() {
            LiteFullUser user = new LiteFullUser();
            user.setName("A哥-lite-inner");
            user.setAge(18);
            return user;
        }
    }
}
