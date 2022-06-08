package com.it.bean.import_pkg;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class DeferredImportSelectorDemo implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("=============DeferredImportSelectorDemo");
        return new String[]{DeferredMarkBean.class.getName()};
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        //步骤1,这个返回null 直接调用上面的selectImports
        return DeferredImportSelectorGroupDemo.class;
    }

    private static class DeferredImportSelectorGroupDemo implements DeferredImportSelector.Group {

        List<Entry> list = new ArrayList<>();

        //步骤2
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            System.out.println("=============DeferredImportSelectorGroupDemo.process");
            String[] strings = selector.selectImports(metadata);
            for (String string : strings) {
                list.add(new Entry(metadata, string));
            }
        }

        //步骤3
        @Override
        public Iterable<Entry> selectImports() {
            System.out.println("============DeferredImportSelectorGroupDemo.selectImports");
            return list;
        }
    }
}
