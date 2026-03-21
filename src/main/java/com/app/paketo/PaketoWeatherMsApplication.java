package com.app.paketo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Paketo Weather Service API", version = "1.0", description = "Documentation for Paketo Service API"))
public class PaketoWeatherMsApplication {

	//http://localhost:8081/swagger-ui/index.html#/
	public static void main(String[] args) {
		SpringApplication.run(PaketoWeatherMsApplication.class, args);
	}

}
