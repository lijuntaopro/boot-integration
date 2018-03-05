package cn.lijuntao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {
	@GetMapping("/hello")
	@RequestMapping("/hello")
	public String say(){
		System.out.println("hello");
		return "hello";
	}
}
