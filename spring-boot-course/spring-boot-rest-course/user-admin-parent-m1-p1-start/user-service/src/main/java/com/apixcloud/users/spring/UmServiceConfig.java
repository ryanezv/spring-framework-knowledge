package com.apixcloud.users.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.apixcloud.users.services" })
public class UmServiceConfig {

    public UmServiceConfig() {
        super();
    }

    // beans

}
