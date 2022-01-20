package com.it.bean.anntation_class;

import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Lazy
@Description("测试注解")
public class ComponentTrigerClass {
}
