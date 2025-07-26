package com.sachin.QuizServiceMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizServiceMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceMicroApplication.class, args);
	}

}
