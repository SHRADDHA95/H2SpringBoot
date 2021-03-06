package com.example.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.gpac.dbConfig.DbConfiguration;

@SpringBootApplication(scanBasePackages = {"com.gpac.controller"})
@Import(DbConfiguration.class)
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
