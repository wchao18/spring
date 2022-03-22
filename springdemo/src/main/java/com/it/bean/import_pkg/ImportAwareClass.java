package com.it.bean.import_pkg;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import({DeferredImportSelectorDemo.class,SelectImportClass.class,ImportAwareBean.class})
public class ImportAwareClass {
}
