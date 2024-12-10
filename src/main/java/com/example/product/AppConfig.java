package com.example.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = {"com.example.product"})
public class AppConfig {
	
	@Bean
	EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("abc");
	}
	

}
