package com.imooc.controller;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

@Controller(value = "helloWorld")
public class HelloController {
	/*@Autowired
	private HelloService helloService;
	public void handleRequest(){
		helloService.sayHello();
		helloService.JustWantToThrowException();
	}*/
}
