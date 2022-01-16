package com.it.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 应用：mybatis和spring的整合
 * 工厂bean只有在用的时候才会getBean
 */
public class UserFactoryBean implements FactoryBean<User>{
	@Override
	public User getObject() throws Exception {
        System.out.println("工厂bean创建");
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

    public static void main(String[] args) {
        System.out.println("类型是否匹配：" + FactoryBean.class.isAssignableFrom(String.class));
    }
}
