package com.apixcloud.umusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.apixcloud.umusers.persistence.daos")
@EnableJpaAuditing
public class UmUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmUsersApplication.class, args);
	}
}
