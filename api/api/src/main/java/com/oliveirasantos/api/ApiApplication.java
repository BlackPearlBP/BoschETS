package com.oliveirasantos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	@Autowired
	private ApiServiceWeather apiServiceWeather;
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String weatherData = apiServiceWeather.getWeather(0, 0);
		System.out.println("API data: "+weatherData);

		FileService.saveDataToFile(weatherData);
	}
	
}
