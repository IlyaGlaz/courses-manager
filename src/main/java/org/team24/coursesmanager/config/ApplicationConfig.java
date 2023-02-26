package org.team24.coursesmanager.config;

import lombok.RequiredArgsConstructor;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
@ComponentScan("org.team24.coursesmanager")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    private final Environment env;

    @Bean
    public BasicDataSource dataSource() {
        var dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClass"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        Properties hibernateProps = new Properties();
        hibernateProps.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        hibernateProps.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        hibernateProps.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.team24.coursesmanager.entity");
        sessionFactory.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        sessionFactory.setHibernateProperties(hibernateProps);

        return sessionFactory;
    }
}
