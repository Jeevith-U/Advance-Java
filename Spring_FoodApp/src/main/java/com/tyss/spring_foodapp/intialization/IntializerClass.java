package com.tyss.spring_foodapp.intialization;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.tyss.spring_foodapp.configuration.ConfigurationClass;

public class IntializerClass extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class [] {ConfigurationClass.class} ;
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}

}
