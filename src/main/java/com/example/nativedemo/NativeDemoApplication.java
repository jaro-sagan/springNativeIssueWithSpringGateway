package com.example.nativedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(value = ServerProperties.class)
public class NativeDemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(NativeDemoApplication.class);

	@Autowired
	private ServerProperties serverProperties;

	public static void main(String[] args) {
		SpringApplication.run(NativeDemoApplication.class, args);
	}

	@RequestMapping("/")
	public Mono<String> home() {
		LOGGER.info("Server Properties: {}", serverProperties);
		LOGGER.info("Server Properties, servlet: {}", serverProperties.getServlet());
		return Mono.just("Hello World!");
	}
}

