package com.example.ottback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OttbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttbackApplication.class, args);
	}

}
