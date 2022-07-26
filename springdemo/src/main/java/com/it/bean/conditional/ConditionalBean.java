package com.it.bean.conditional;

import com.it.bean.propertiesbean.PropertiesPro;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
//@ConditionOnClass(name = {"com.it.bean.propertiesbean.PropertiesPro"})
@ConditionOnBean(value = PropertiesPro.class)
public class ConditionalBean {


}
