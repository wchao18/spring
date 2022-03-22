package com.it.bean.import_pkg;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

public class SelectImportClass implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("SelectImportClass====================");

        //获取导入类上的注解
        MergedAnnotations annotations = importingClassMetadata.getAnnotations();


        return new String[]{Jack.class.getName()};
    }
}
