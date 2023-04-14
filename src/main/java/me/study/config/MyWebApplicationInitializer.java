package me.study.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    // Spring ServletContextListener 설정
    XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
    rootContext.setConfigLocations(new String[]{"classpath*:spring/*-context.xml","classpath*:spring/context-*.xml"});
    rootContext.refresh();
    rootContext.start();
    servletContext.addListener(new ContextLoaderListener(rootContext));

    // Spring ServletContextListener 설정
    XmlWebApplicationContext webContext = new XmlWebApplicationContext();
    webContext.setConfigLocation("classpath*:spring/dispatcherServlet.xml");
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
        new DispatcherServlet(webContext));
    dispatcher.addMapping("/");
    dispatcher.setLoadOnStartup(1);

    // CharacterEncodingFilter 설정
    FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("htmlTagFilter", new CharacterEncodingFilter("UTF-8"));
    encodingFilter.addMappingForUrlPatterns(null, false, "/");

    // Spring RequestContextListener 설정
    servletContext.addListener(new RequestContextListener());
  }
}
