package com.imooc.controller;

import com.imooc.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.inject.Named;

@Named(value = "hiController")
public class HiController {
	/*@Autowired
	private HiService hiService;
	public void handleRequest(){
		hiService.sayHi();
		hiService.justWantToSayHi();
	}*/
}
