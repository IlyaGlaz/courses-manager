package org.team24.coursesmanager.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class ClassWebXML extends AbstractAnnotationConfigDispatcherServletInitializer { // web.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;                                                                    // return null;new Class[0];
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{HibernateConf.class};                                        // class with configuration
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
