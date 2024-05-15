package com.apixcloud.courses.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@ComponentScan("com.apixcloud.courses.security")
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class UsersJavaSecurityConfig {

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()    

            //.anyRequest()
            .regexMatchers("^/actuator/*")            
            .permitAll()            
            .antMatchers("/h2-console/**")
            .permitAll()
            .antMatchers("/**")
            
            .authenticated()
            //.hasRole("ROLE_ADMIN") 
            //.hasAnyRole("ROLE_ADMIN")
            //.hasRole("ADMIN")
            //.hasAuthority("ROLE_ADMIN")            
            //.access("hasRole('ADMIN')")

            .and()
            .httpBasic()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  
        
        /* X-Frame-Options tell to browser should be allowed to render <iframe> <iframe> <embed> or <object> */
        http.headers().frameOptions().disable();

		return http.build();
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* 
    @Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
			.username("user")
			.password("password")
			.roles("USER")
			.build();

		return new InMemoryUserDetailsManager(userDetails);
	}*/
}
