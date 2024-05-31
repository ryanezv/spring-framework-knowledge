package com.apixcloud.courses.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@ComponentScan("com.apixcloud.courses.security")
@SuppressWarnings("deprecation")
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
     
    public ResourceServerConfig() {
        super();
    }

    // global security concerns


    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth, AuthenticationProvider authProvider) {
        auth.authenticationProvider(authProvider);
    }

    // http security concerns

    @Override
    public void configure(final HttpSecurity http) throws Exception {        
        http.
            authorizeRequests()
            .antMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**")
            .permitAll()
            .antMatchers("/actuator/**")            
            .permitAll()
            .antMatchers("/oauth/**")
            .permitAll()
            .antMatchers("/**")
            .authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
            csrf().disable();
    }
    
}
