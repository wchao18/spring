package com.it.bean.destory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class DestroyBean2 implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy2销毁回调");
    }
}
