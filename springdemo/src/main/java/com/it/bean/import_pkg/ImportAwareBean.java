package com.it.bean.import_pkg;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class ImportAwareBean implements ImportAware {
    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        //这里会拿到ImportAwareClass是上面的注解 比如@Componnent
        Set<String> annotationTypes = importMetadata.getAnnotationTypes();
    }
}
