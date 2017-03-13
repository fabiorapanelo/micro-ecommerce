package com.fabiorapanelo.catalog;

import java.util.Arrays;

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
	public CommandLineRunner run(@Autowired SearchableCatalogItemRepository repository) {
		
		return (args) -> {

			repository.deleteAll();
	
			// insert some products
			SearchableCatalogItem sci1 = new SearchableCatalogItem();
			sci1.setId("1");
			sci1.setName("Moto G5");
			sci1.setChracteristics(Arrays.asList("5.5", "Android 7", "32GB"));
			sci1.setCategories(Arrays.asList("Smartphone", "Motorola", "Celular"));
			
			SearchableCatalogItem sci2 = new SearchableCatalogItem();
			sci2.setId("2");
			sci2.setName("Moto G4");
			sci2.setChracteristics(Arrays.asList("5.0", "Android 6", "16GB"));
			sci2.setCategories(Arrays.asList("Smartphone", "Motorola", "Celular"));
			
			repository.save(sci1);
			repository.save(sci2);
	
			// fetch all
			System.out.println("SearchableCatalogItem found by findAll():");
			System.out.println("----------------------------");
			for (SearchableCatalogItem sci : repository.findAll()) {
				System.out.println(sci);
			}
			System.out.println();
	
			System.out.println("SearchableCatalogItem found with findByNameStartingWith('So'):");
			System.out.println("--------------------------------");
			for (SearchableCatalogItem sci : repository.findByNameStartingWith("Moto")) {
				System.out.println(sci);
			}
			System.out.println();
		};
	}
}
