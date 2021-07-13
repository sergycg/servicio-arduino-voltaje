package com.arduino.voltaje;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${herokuNotIdle.url}")
	private String herokuNotIdle_url;
	
	public static void main(String[] args) {
		SpringApplication.run(ServicioArduinoVoltajeApplication.class, args);
	}
	
	
//	* "0 0 * * * *" = the top of every hour of every day.
//	* "*/10 * * * * *" = every ten seconds.
//	* "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
//	* "0 0 8,10 * * *" = 8 and 10 o'clock of every day.
//	* "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
//	* "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
//	* "0 0 0 25 12 ?" = every Christmas Day at midnight
	
//    @Scheduled(fixedDelay = 60*1000*15, initialDelay = 500)
    @Scheduled(cron = "${herokuNotIdle.cronExpression}")
    public void herokuNotIdle() {
	System.out.println(" INIT - Heroku not idle execution ");
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> response = restTemplate.exchange(herokuNotIdle_url, HttpMethod.GET, null, String.class);
	System.out.println(response);
	System.out.println(" FINISH - Heroku not idle execution");
    }
}
