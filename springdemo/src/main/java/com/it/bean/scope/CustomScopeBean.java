package com.it.bean.scope;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("refreshScope")
public class CustomScopeBean {

}
