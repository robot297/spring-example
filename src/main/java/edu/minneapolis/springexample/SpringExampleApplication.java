package edu.minneapolis.springexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringExampleApplication {
	private static Logger LOG = LoggerFactory.getLogger(SpringExampleApplication.class);

	public static void main(String[] args) {
		LOG.info("Application is starting.");
		SpringApplication.run(SpringExampleApplication.class, args);
		LOG.info("Application has started.");
	}

}
