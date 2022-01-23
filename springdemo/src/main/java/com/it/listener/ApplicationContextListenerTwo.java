package com.it.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationContextListenerTwo implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof MessageSourceEvent){
            System.out.println("进入到监听器类--two");
            MessageSourceEvent messageSourceEvent = (MessageSourceEvent) event;
            messageSourceEvent.print();
        }
    }
}
