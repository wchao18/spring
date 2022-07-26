package com.it.listener;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.it.listener")
@ImportResource("classpath*:spring/spring-listener.xml")
public class ListenerConfig {
}
