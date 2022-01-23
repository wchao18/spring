package com.it.listener;

import org.springframework.context.ApplicationEvent;

public class MessageSourceEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1033669571503959380L;

    public MessageSourceEvent(Object source) {
        super(source);
    }

    public void print(){
        System.out.println("进入到事件的方法中！");
    }

}
