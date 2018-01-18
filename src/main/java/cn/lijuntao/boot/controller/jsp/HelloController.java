package cn.lijuntao.boot.controller.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/say")
	public String say(){
		System.out.println("jsp say hello");
		return "hello";
	}
}
