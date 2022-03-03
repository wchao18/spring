package com.it.bean.scanbean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.it.bean")
@PropertySource(value = "classpath:application.properties")
public class ScanBean {

}
