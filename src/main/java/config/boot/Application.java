package config.boot;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import config.jsp.WebInitializer;

@SpringBootApplication
//@ComponentScan(basePackages={"cn.lijuntao.boot"})
//@EnableWebMvc
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public ServletContextInitializer freeInitializer() {
    	return new ServletContextInitializer() {
    		public void onStartup(ServletContext servletContext) throws ServletException {
    			new config.free.WebInitializer().onStartup(servletContext);
    		}
    	};
    }
    
    @Bean
    public ServletContextInitializer jspInitializer(ServletContext servletContext) {
    	return new ServletContextInitializer() {
    		public void onStartup(ServletContext servletContext) throws ServletException {
    			new WebInitializer().onStartup(servletContext);
    		}
    	};
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
