package com.apixcloud.courses.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@ComponentScan("com.apixcloud.courses.security")
public class UsersJavaSecurityConfig {

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*http  
            .csrf().disable()                      
			.authorizeHttpRequests((authorize) -> authorize
				.anyRequest().authenticated()
			)            
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());
            //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        */
        http
            .csrf().disable()
            .authorizeRequests()            
            
            .anyRequest()

            .authenticated()
            .and()
            .httpBasic()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  
                                            
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
