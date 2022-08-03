package com.example.testservice;

import com.example.testservice.shared.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
public class TestServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestServiceApplication.class, args);
	}

}
