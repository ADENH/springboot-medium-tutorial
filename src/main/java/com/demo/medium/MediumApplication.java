package com.demo.medium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MediumApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumApplication.class, args);
	}

}
