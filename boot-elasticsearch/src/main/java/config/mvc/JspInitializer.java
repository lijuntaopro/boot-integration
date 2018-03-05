package config.mvc;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JspInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	/**
	 * 多个继承AbstractAnnotationConfigDispatcherServletInitializer，只能定义一个，如果使用spring-boot启用，就全不能设置
	 * 否则会造成root webApplication出现多个，导致启动失败
	 */
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { JspConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/jsp/*" };
	}
	
	@Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
            new HiddenHttpMethodFilter(), new CharacterEncodingFilter() };
    }

	@Override
	protected String getServletName() {
		return new String("jspServlet");
	}
	
	
}
