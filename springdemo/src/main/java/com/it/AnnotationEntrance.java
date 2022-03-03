package com.it;

import com.it.bean.scanbean.ScanBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description 注解启动类
 * @date 2021/08/09 18:18
 */
public class AnnotationEntrance {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ScanBean.class);

    }
}
