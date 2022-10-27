package com.example.ApiRestTecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;


@SpringBootApplication
public class ApiRestTecnicoApplication {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
					.components(new Components())
					.info(new Info().title("API CHISTES"));
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiRestTecnicoApplication.class, args);
	}

}
