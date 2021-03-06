package browser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BrowserApp {

	public static void main(String[] args) {
		SpringApplication.run(BrowserApp.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

		};
	}

}