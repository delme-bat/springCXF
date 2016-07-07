package com.bush76.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {
	
	@RequestMapping("/json")
	public @ResponseBody String json(){
		return "{\"name\":\"zhangsan\"}";
	}
	
	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	
}
