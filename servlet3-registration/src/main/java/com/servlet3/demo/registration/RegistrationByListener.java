package com.servlet3.demo.registration;

import javax.servlet.*;
import java.util.EnumSet;

public class RegistrationByListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        ServletRegistration sr = sc.addServlet("servletByRegistration","com.servlet3.demo.controller.ServletByRegistration");
        sr.addMapping("/ServletByRegistration");


        FilterRegistration fr1 = sc.addFilter("filterByRegistration","com.servlet3.demo.filter.FilterByRegistration1");
         fr1.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/ServletByRegistration");
        
        FilterRegistration fr2 = sc.addFilter("filterByRegistration2","com.servlet3.demo.filter.FilterByRegistration2");
         fr2.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/ServletByRegistration");
        
        //sc.addListener("com.servlet3.demo.Listener.ListenerByRegistration");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
