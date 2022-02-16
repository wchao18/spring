package com.it.bean.propertiesbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class PropertiesPro implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        StandardEnvironment standardEnvironment = (StandardEnvironment) beanFactory.getBean(Environment.class);
        Properties properties = new Properties();
        properties.put("my2022", "java");
        PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("2022", properties);
        MutablePropertySources propertySources = standardEnvironment.getPropertySources();
        propertySources.addLast(propertiesPropertySource);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
