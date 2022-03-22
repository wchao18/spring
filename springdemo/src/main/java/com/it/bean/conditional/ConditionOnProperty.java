package com.it.bean.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(value = OnPropertyCondition.class)
public @interface ConditionOnProperty {
    Class<?>[] value() default {};

    String[] name() default {};
}
