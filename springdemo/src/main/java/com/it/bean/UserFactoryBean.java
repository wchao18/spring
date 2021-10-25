package com.it.bean;

import com.it.bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * 应用：mybatis和spring的整合
 */
public class UserFactoryBean implements FactoryBean<User> {
	@Override
	public User getObject() throws Exception {
        System.out.println("工厂bean创建");
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
