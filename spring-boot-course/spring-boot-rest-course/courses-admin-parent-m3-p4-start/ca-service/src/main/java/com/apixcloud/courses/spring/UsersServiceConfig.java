package com.apixcloud.courses.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.apixcloud.courses.services" })
public class UsersServiceConfig {

    public UsersServiceConfig() {
        super();
    }
}
