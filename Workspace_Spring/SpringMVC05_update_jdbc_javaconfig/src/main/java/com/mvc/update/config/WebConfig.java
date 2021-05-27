package com.mvc.update.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// ApplicationConfig
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(); 
		
		// @Configration 걸려있는 얘들 사용해주는 얘이다. config 설정 클래스를 지정한다.
		applicationContext.register(ApplicationConfig.class);
		
		// Listner
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		
		// ServletConfig
		AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
		servletConfig.register(ServletConfig.class);
		
		ServletRegistration.Dynamic dispatcherServlet = 
				servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
		dispatcherServlet.setLoadOnStartup(1); // LoadOnStartuo은 servlet이 여러 개 있을 때 순서 정해주는 것
		dispatcherServlet.addMapping("*.do");
		
		// encodingFilter
		FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");
		
		
		
		

	}

}
