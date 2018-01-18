package cn.lijuntao.boot.controller.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/say")
	public String say(){
		System.out.println("freemarker say hello");
		return "hello";
	}
}
