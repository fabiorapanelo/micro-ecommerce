package com.fabiorapanelo.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		//https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
