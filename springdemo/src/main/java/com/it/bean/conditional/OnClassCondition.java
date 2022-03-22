package com.it.bean.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.util.Map;

public class OnClassCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (metadata.isAnnotated(ConditionOnClass.class.getName())) {
            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
            try {
                ClassUtils.forName(annotationAttributes.get("name").toString(), ClassUtils.getDefaultClassLoader());
                return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
