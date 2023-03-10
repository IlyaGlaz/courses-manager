package org.team24.coursesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc           //For the Swagger to work
@SpringBootApplication
public class CoursesApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoursesApplication.class, args);
    }
}
