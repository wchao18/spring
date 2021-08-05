package com.it.destory;

import org.springframework.beans.factory.DisposableBean;

/**
 * 测试三种destory回调
 */
public class Destroy {


    /**
     * 实现了DisposableBean接口
     */
    public static class Destroy1 implements DisposableBean {

        @Override
        public void destroy() throws Exception {
            System.out.println("destroy1销毁回调");
        }

        public void destroy2() throws Exception {
            System.out.println("destroy1销毁回调");
        }
    }

    /**
     * 定义了destroy-method属性
     */
    public static class Destroy2 {
        public void destroy() throws Exception {
            System.out.println("destroy2销毁回调");
        }
    }

    /**
     * 没有定义回调方法
     */
    public static class Destroy3 {
        public void destroy() throws Exception {
            System.out.println("destroy3销毁回调");
        }
    }
}
