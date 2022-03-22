package com.it.bean.metaDataReader;

import com.it.bean.scanbean.ScanBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class MetaDataReaderTest {

    @Test
    public void test1() {
        FileSystemResource fileSystemResource = new FileSystemResource("绝对路径Jack.class");
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();
        try {
            MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(fileSystemResource);
            System.out.println(metadataReader);
            Set<MethodMetadata> annotatedMethods = metadataReader.getAnnotationMetadata().getAnnotatedMethods(Component.class.getName());
            for (MethodMetadata annotatedMethod : annotatedMethods) {
                System.out.println(annotatedMethod.getMethodName() + "--" + annotatedMethod.getReturnTypeName());
            }
            Map<String, Object> annotationAttributes = metadataReader.getAnnotationMetadata().getAnnotationAttributes(Component.class.getName(), false);
            System.out.println(annotationAttributes);

            MergedAnnotations annotations = metadataReader.getAnnotationMetadata().getAnnotations();
            System.out.println(annotations);
            MergedAnnotation<Component> componentMergedAnnotation = annotations.get(Component.class);
            System.out.println(componentMergedAnnotation);
            AnnotationAttributes annotationAttributes1 = componentMergedAnnotation.asAnnotationAttributes(MergedAnnotation.Adapt.ANNOTATION_TO_MAP);
            System.out.println(annotationAttributes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanBean.class);
        AnnotationMetaDataDemo rl = applicationContext.getBean(AnnotationMetaDataDemo.class);
        rl.metaData();
    }
}
