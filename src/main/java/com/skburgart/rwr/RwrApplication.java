package com.skburgart.rwr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RwrApplication {

	public static void main(String[] args) {
		SpringApplication.run(RwrApplication.class, args);
	}
}
