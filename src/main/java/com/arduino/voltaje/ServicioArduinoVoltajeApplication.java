package com.arduino.voltaje;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioArduinoVoltajeApplication {

//	@PostConstruct
//	void started() {
//		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServicioArduinoVoltajeApplication.class, args);
	}

}
