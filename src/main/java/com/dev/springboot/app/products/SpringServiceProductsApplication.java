package com.dev.springboot.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringServiceProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceProductsApplication.class, args);
	}
}
