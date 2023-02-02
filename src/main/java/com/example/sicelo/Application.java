package com.example.sicelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ServletComponentScan
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class}, scanBasePackages = "com.example.sicelo")
@EnableJpaRepositories("com.example.sicelo.persistence.repo")
@EntityScan("com.example.sicelo.persistence.model")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
