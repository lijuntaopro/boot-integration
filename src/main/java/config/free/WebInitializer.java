package config.free;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements org.springframework.boot.web.servlet.ServletContextInitializer{
	
	/**
	 * 多个继承AbstractAnnotationConfigDispatcherServletInitializer，只能定义一个，如果使用spring-boot启用，就全不能设置
	 * 否则会造成root webApplication出现多个，导致启动失败
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/freemarker/*" };
	}
	
	@Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
            new HiddenHttpMethodFilter(), new CharacterEncodingFilter() };
    }

	@Override
	protected String getServletName() {
		return new String("freemarkerServlet");
	}
	
	
}
