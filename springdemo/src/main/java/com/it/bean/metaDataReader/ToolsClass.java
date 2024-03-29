package com.it.bean.metaDataReader;

import com.it.bean.import_pkg.Jack;
import com.it.bean.innerclass.Student;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

public class ToolsClass {

    @Test
    public void classUtils() {
        String packageName = ClassUtils.getPackageName(Jack.class);
        System.out.println(packageName);
    }

    @Test
    public void reflectionUtils() {
        Method[] declaredMethods = ReflectionUtils.getDeclaredMethods(Jack.class);
        ReflectionUtils.doWithFields(Jack.class, field -> {
            System.out.println(field.getName());
        });
    }

    @Test
    public void beanUtils() {
        Class<?> name = BeanUtils.findPropertyType("name", Jack.class);
        System.out.println(name);
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void BridgeMethodResolver() {
        ReflectionUtils.getAllDeclaredMethods(Jack.class);
        Method method1 = ClassUtils.getMethod(Jack.class, "method", new Class[]{Object.class});
        System.out.println(method1.isBridge() + "--" + method1.hashCode());

        Method method = ClassUtils.getMethod(Jack.class, "method", new Class[]{String.class});
        System.out.println(method.isBridge() + "--" + method.hashCode());

        Method bridgedMethod = BridgeMethodResolver.findBridgedMethod(method1);
        System.out.println(bridgedMethod.hashCode());
    }

    @Test
    public void PropertiesLoaderUtils() {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties", ClassUtils.getDefaultClassLoader());
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     1.getSuperType()：获取直接父类型
     2.getInterfaces()：获取接口类型
     3.getGeneric(int...)：获取类型携带的泛型类型
     4.resolve()：Type对象到Class对象的转换
    */
    @Test
    public void ResolvableType() {
        ResolvableType intfType = ResolvableType.forClass(Jack.class).getInterfaces()[0];
        System.out.println(intfType.resolveGeneric(0));

        ResolvableType usernameType = ResolvableType.forField(ReflectionUtils.findField(Student.class, "username"));
        System.out.println(usernameType.getType());
        System.out.println(usernameType.getRawClass());

        ResolvableType mapType = ResolvableType.forField(ReflectionUtils.findField(Student.class, "map"));
        System.out.println(mapType.getType());
        System.out.println(mapType.resolveGeneric(0));
        System.out.println(mapType.resolveGeneric(1));

        ResolvableType listType = ResolvableType.forField(ReflectionUtils.findField(Student.class, "list"));
        System.out.println(listType.getType());
        System.out.println(listType.resolveGeneric(0));
        System.out.println(listType.getGeneric(0).resolveGeneric(0));
        System.out.println(listType.getGeneric(0).resolveGeneric(1));

        ResolvableType getMapType = ResolvableType.forMethodReturnType(ReflectionUtils.findMethod(Student.class, "getMap", List.class));
        System.out.println(getMapType.getType());
        System.out.println(getMapType.resolveGeneric(0));
        System.out.println(getMapType.resolveGeneric(1));

        ResolvableType paramType = ResolvableType.forMethodParameter(ReflectionUtils.findMethod(Student.class, "getMap",List.class),0);
        System.out.println(paramType.getType());
        System.out.println(paramType.resolveGeneric(0));
    }


}
