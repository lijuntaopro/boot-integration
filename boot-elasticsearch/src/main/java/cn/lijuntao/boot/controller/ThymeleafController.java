package cn.lijuntao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thy")
public class ThymeleafController {
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("thy say hello");
		return "hello";
	}
}
