package se.home;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SmarthomeApplication {

	@PostConstruct
	public void initLogger() {
		MDC.put("application", "SmarthomeApplication");
	}

	public static void main(String[] args) {
		SpringApplication.run(SmarthomeApplication.class, args);
	}
}
