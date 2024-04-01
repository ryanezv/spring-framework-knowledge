package com.apixcloud.courses.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "com.apixcloud.courses.controllers" })
@EnableWebMvc
public class UsersWebConfig {

    public UsersWebConfig() {
        super();
    }
}
