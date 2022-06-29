package com.it;

import com.it.aop.AopConfig;
import com.it.aop.scopedproxy.ScopedProxyBean;
import com.it.aop.service.AopAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopAnnotationEntrance {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AopConfig.class);

       /* AopAccountService aopAccountService = annotationConfigApplicationContext.getBean(AopAccountService.class);
        aopAccountService.addAccount(1L,"test");*/

        //不加 proxyMode = ScopedProxyMode.TARGET_CLASS
       /* ScopedProxyBean scopedProxyBean = annotationConfigApplicationContext.getBean(ScopedProxyBean.class);
        scopedProxyBean.code();//相同
        scopedProxyBean.code();//相同*/
        //加 proxyMode = ScopedProxyMode.TARGET_CLASS
        ScopedProxyBean scopedProxyBean2 = annotationConfigApplicationContext.getBean(ScopedProxyBean.class);
        scopedProxyBean2.code(); //不同
        scopedProxyBean2.code(); //不同

    }
}
