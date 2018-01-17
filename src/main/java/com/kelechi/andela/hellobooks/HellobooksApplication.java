package com.kelechi.andela.hellobooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.kelechi.andela.hellobooks.repository")
public class HellobooksApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HellobooksApplication.class, args);
	}
}
