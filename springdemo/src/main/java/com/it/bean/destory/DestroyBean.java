package com.it.bean.destory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * 测试三种destory回调
 */
@Component
public class DestroyBean /*implements DisposableBean*/{


    @PreDestroy
    public void destroy111() throws Exception {
        System.out.println("destroy1销毁回调");
    }
}
