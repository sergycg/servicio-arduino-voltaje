package com.arduino.voltaje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioArduinoVoltajeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioArduinoVoltajeApplication.class, args);
	}

}
