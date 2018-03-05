package cn.lijuntao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("jsp say hello");
		return "hello";
	}
}
