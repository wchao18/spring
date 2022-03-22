package com.it.bean.import_pkg;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportBeanDefinitionRegistrarDemo implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Jack.class);

        MutablePropertyValues propertyValues = genericBeanDefinition.getPropertyValues();
        propertyValues.addPropertyValue("name", "jackValue2022");

        registry.registerBeanDefinition("jack", genericBeanDefinition);


    }
}
