package config.boot;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import config.mvc.JspInitializer;
import config.root.RootConfig;

@SpringBootApplication(exclude={JpaRepositoriesAutoConfiguration.class, DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@ComponentScan(basePackages={"cn.lijuntao.boot"})
//@EnableWebMvc
@Import({RootConfig.class})
//@ComponentScan(basePackages={"cn.lijuntao.boot.repository"})
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public ServletContextInitializer freeInitializer() {
    	return new ServletContextInitializer() {
    		public void onStartup(ServletContext servletContext) throws ServletException {
    			new config.mvc.FreeMarkerInitializer().onStartup(servletContext);
    		}
    	};
    }
    
    @Bean
    public ServletContextInitializer jspInitializer(ServletContext servletContext) {
    	return new ServletContextInitializer() {
    		public void onStartup(ServletContext servletContext) throws ServletException {
    			new JspInitializer().onStartup(servletContext);
    		}
    	};
    }
    
    @Bean
    public ServletContextInitializer WebInitializer(ServletContext servletContext) {
    	return new ServletContextInitializer() {
    		public void onStartup(ServletContext servletContext) throws ServletException {
    			new config.mvc.WebInitializer().onStartup(servletContext);
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
