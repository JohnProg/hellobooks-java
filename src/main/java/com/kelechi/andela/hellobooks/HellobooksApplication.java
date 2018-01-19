package com.kelechi.andela.hellobooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class HellobooksApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HellobooksApplication.class, args);
	}
}
