package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lijuntao.axis.service.interfaces.ITestService;

@Configuration
@EnableAutoConfiguration
@RestController
@ServletComponentScan
@ComponentScan(basePackages="cn.lijuntao.axis")
public class Application {
	String name = "World";
	
	String name2 = "World";
	
	@Autowired
	private ITestService testService;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("home");
		return testService.sayHello("lijuntao");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
