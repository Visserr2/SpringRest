package nl.thuis.tutorial.rest.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import nl.thuis.tutorial.rest.config.SpringRestConfig;

public class SpringRestDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	private static final String[] ROOT = {"/"};

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringRestConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return ROOT;
	}

}
