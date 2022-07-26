package com.it.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//不扫描有@Controller注解的类
@ComponentScan(value = "com.enjoy.jack",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
        /*,@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {AppConfig.class})*/
})
public class SpringContainer {
}
