package cn.lijuntao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/free")
public class FreemarketController {
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("freemarket say hello");
		return "hello";
	}
}
