package com.apixcloud.users.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.apixcloud.users")
@EntityScan("com.apixcloud.users.persistence")
@EnableJpaRepositories("com.apixcloud.users.persistence.daos")
public class UsersApp {

	public static void main(String[] args) {
		SpringApplication.run(UsersApp.class, args);
	}

}
