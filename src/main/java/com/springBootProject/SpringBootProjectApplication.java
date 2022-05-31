package com.springBootProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class SpringBootProjectApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootProjectApplication.class);


	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootProjectApplication.class, args);
		log.info("RUN");
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}
