package com.arduino.voltaje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

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

    @Scheduled(fixedDelay = 60*1000*15, initialDelay = 500)
    public void herokuNotIdle() {
	System.out.println(" INIT - Heroku not idle execution ");
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> response = restTemplate.exchange("https://arduino-voltaje-heroku.herokuapp.com/help", HttpMethod.GET, null, String.class);
//	ResponseEntity<String> response2 = restTemplate.exchange("https://eureka-server-heroku.herokuapp.com/", HttpMethod.GET, null, String.class);
	System.out.println(" FINISH - Heroku not idle execution: " + response);
//	System.out.println(" FINISH - Heroku not idle execution: " + response2);

    }
}
