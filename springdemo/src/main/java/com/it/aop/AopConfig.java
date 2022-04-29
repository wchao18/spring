package com.it.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy(proxyTargetClass = false,exposeProxy = true)
@ComponentScan("com.it.aop")
public class AopConfig {
}
