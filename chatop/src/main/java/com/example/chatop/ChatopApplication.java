package com.example.chatop;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ChatopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatopApplication.class, args);
	}

	@Bean
	public OpenAPI openApiInformation() {
		Server localServer = (new Server()).url("http://localhost:9099").description("API Server");
		Contact contact = (new Contact()).email("paul.marniquet@gmail.com").name("Paul Marniquet");
		Info info = (new Info()).contact(contact).description("Spring Boot Project - Create an API for rentals").title("Chatop - API").version("V1.0.0").license((new License()).name("License"));
		return (new OpenAPI()).info(info).addServersItem(localServer);
	}
}
