package com.it.tomcat;


import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class LoadServletImpl implements LoadServlet {
    @Override
    public void loadOnstarp(ServletContext servletContext) {
        ServletRegistration.Dynamic initServlet = servletContext.addServlet("initServlet", InitServlet.class);
        initServlet.setLoadOnStartup(1);
        initServlet.addMapping("/init");


        ServletRegistration aDefault = servletContext.getServletRegistration("default");
        aDefault.addMapping("*.css","*.gif","*.jpg","*.js","*.JPG");
//        ServletRegistration.Dynamic defaults = servletContext.addServlet("default", DefaultServlet.class);
//        defaults.setLoadOnStartup(1);
//        defaults.addMapping("*.css","*.gif","*.jpg","*.js","*.JPG");
    }
}
