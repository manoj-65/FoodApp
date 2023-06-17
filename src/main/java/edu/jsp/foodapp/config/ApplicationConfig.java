package edu.jsp.foodapp.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class ApplicationConfig {
	@Bean
	public OpenAPI swaggerDocOpenApi() {
		Server devlopmentServer = new Server();
		devlopmentServer.setUrl("http://localhost:8080");
		devlopmentServer.setDescription("This Url is For Development");

		Server productionServer = new Server();
		productionServer.setUrl("http://localhost:8080");
		productionServer.setDescription("This Url is For Production");

		Contact contact = new Contact();
		contact.setName("FoodApp");
		contact.setEmail("info.foodapp.in");
		contact.setUrl("www.foodapp.in");

		License license = new License();
		license.name("MIT License");
		license.url("License Url Coming Soon!! ");

		Info info = new Info();
		info.title("FoodApp RestApi's");
		info.version("1.0.0");
		info.contact(contact);
		info.description("This application is desined for FoodApp to Avoid the Manual Work");
		info.termsOfService("www.foodapp.in/terms");
		info.license(license);

		OpenAPI openAPI = new OpenAPI();
		openAPI.info(info);
		openAPI.servers(Arrays.asList(devlopmentServer, productionServer));

		return openAPI;
	}
}
