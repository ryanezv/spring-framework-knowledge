package com.apixcloud.courses.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.apixcloud.courses")
@EntityScan("com.apixcloud.courses.persistence")
@EnableJpaRepositories("com.apixcloud.courses.persistence.daos")
public class UsersApp {

	public static void main(String[] args) {	
		SpringApplication.run(UsersApp.class, args);
	}

}
