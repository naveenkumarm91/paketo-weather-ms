package com.app.paketo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaketoWeatherMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaketoWeatherMsApplication.class, args);
	}

}
