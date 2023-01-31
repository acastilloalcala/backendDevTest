package com.acastillo.dev.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class BackendDevTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDevTestApplication.class, args);
	}

}
