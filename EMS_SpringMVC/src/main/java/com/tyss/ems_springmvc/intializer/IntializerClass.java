package com.tyss.ems_springmvc.intializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.tyss.ems_springmvc.config.ConfigurationClass;

public class IntializerClass extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class [] {ConfigurationClass.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}

}
