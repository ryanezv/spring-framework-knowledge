package com.apixcloud.courses.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.apixcloud.courses")
public class UsersApp {

	public static void main(String[] args) {	
		SpringApplication.run(UsersApp.class, args);
	}

}
