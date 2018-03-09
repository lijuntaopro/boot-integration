package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableAutoConfiguration
public class Application {
	
	@RequestMapping("/**")
	public String hello(){
		return "Hello World";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
