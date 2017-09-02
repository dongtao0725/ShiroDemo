package com.dongt.shiroDemo.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ShiroInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic filter = servletContext.addFilter("shiroFilter",org.springframework.web.filter.DelegatingFilterProxy.class);
        filter.addMappingForUrlPatterns(null,false,"/*");
    }
}
