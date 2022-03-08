package com.example.springwebflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//https://www.youtube.com/watch?v=9x7G4f3o90Q&t=1222
@SpringBootApplication
public class SpringwebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebfluxApplication.class, args);
	}

	UserWebClient userWebClient = new UserWebClient();

	@Bean
	CommandLineRunner runner() {
		return args -> {
			userWebClient.consume();
		};
	}

}
