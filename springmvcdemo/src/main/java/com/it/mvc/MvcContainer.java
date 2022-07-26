package com.it.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@ComponentScans
({@ComponentScan(value = "com.enjoy.jack",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)/*,@ComponentScan(basePackageClasses = AppConfig.class)*/})
public class MvcContainer {
}
