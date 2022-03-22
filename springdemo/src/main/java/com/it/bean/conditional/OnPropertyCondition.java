package com.it.bean.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author WangYang
 * @ClassName:
 * @Description:
 * @date 2021-01-10-23:29
 */
public class OnPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if(metadata.isAnnotated(ConditionOnProperty.class.getName())){
            //首先获取到这个类里面的所有的注解信息
            AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(ConditionOnProperty.class.getName(), false));
            String[] names = annotationAttributes.getStringArray("name");
            try {
                Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties", ClassUtils.getDefaultClassLoader());
                for (String name : names) {
                    String property = properties.getProperty(name);
                    if(property.equalsIgnoreCase("true")){
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        }
        return false;
    }
}
