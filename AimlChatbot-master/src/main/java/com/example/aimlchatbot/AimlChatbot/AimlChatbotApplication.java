package com.example.aimlchatbot.AimlChatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.aimlchatbot","com.example.aimlchatbot.*"})
@EnableJpaRepositories(basePackages = {"com.example.aimlchatbot.*"})
@EntityScan(basePackages = {"com.example.aimlchatbot.*"})
public class AimlChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(AimlChatbotApplication.class, args);
	}

}
