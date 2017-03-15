package com.fabiorapanelo.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(@Autowired SearchableItemRepository repository) {
		
		return (args) -> {

		};
	}
}
