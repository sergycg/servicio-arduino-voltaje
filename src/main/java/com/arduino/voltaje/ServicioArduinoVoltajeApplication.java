package com.arduino.voltaje;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class ServicioArduinoVoltajeApplication {

//	@PostConstruct
//	void started() {
//		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServicioArduinoVoltajeApplication.class, args);
	}

    @Scheduled(fixedDelay = 120000, initialDelay = 500)
    public void herokuNotIdle() {
	System.out.println(" Heroku not idle execution ");

    }
}
