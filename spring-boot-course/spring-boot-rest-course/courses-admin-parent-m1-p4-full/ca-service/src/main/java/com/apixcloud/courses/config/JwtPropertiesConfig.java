package com.apixcloud.courses.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "apixcloud.courses.security.jwt")
@Getter
@Setter
@ToString
public class JwtPropertiesConfig {
    
    private String signingKey;
    private String type;
    private String subject;    
}
