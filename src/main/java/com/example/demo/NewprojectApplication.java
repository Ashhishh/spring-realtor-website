package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.demo.storage.StorageProperties;
import com.example.demo.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class NewprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewprojectApplication.class, args);
	}


	 @Bean
	    CommandLineRunner init(StorageService storageService) {
	        return (args) -> {
	            storageService.init();
	        };
	    }  
	 	
	
}
