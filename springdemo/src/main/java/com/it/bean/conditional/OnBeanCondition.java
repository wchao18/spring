package com.it.bean.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotationCollectors;
import org.springframework.core.annotation.MergedAnnotationPredicates;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class OnBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            if (metadata.isAnnotated(ConditionOnBean.class.getName())) {
                MergedAnnotations annotations = metadata.getAnnotations();
                //.class类型转string
                MultiValueMap<String, Object> attributes = annotations.stream(ConditionOnBean.class)
                        .filter(MergedAnnotationPredicates.unique(MergedAnnotation::getMetaTypes))
                        .collect(MergedAnnotationCollectors.toMultiValueMap(MergedAnnotation.Adapt.CLASS_TO_STRING));

                /*MergedAnnotation<ConditionOnBean> cob = annotations.get(ConditionOnBean.class);
                Optional<Object> value = cob.getValue("value");*/
                String[] values = context.getBeanFactory().getBeanNamesForType(ClassUtils.forName(((String[]) attributes.get("value").get(0))[0] + "", ClassUtils.getDefaultClassLoader())
                ,true,false);
                //String[] beanNamesForType = context.getBeanFactory().getBeanNamesForType(CQ.class);
                //final String[] beanDefinitionNames = context.getRegistry().getBeanDefinitionNames();
                if (!StringUtils.isEmpty(values) && values.length > 0) {
                    return true;
                }
            }
        }catch (Exception e) {
            return false;
        }
        return false;
    }
}
