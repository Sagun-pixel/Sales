package com.Supermarket.Sales;

import com.Supermarket.Sales.Service.StorageProperties;
import com.Supermarket.Sales.Service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//to do live debug thing
@SpringBootApplication
//@EnableConfigurationProperties(StorageProperties.class)
//@ComponentScan(basePackages="com.Supermarket.Sales.Controller")
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}
	//@Bean
	//CommandLineRunner init(StorageService storageService) {
	//	return (args) -> {
	//		storageService.deleteAll();
	//		storageService.init();
	//	};
	//}

}
