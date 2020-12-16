package com.foodbank.foodbankapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.PathContainer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class FoodBankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodBankApiApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.foodbank.foodbankapi.controllers"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"FoodBank API",
				"API para utilizar el servicio de ordenes y entregas en la organizacion.",
				"1.0",
				"",
				new springfox.documentation.service.Contact("Gonzalo Calle", "https://github.com/gicck", "ccg0025022@est.univalle.edu"),
				"Licencia MIT",
				"",
				Collections.emptyList());
	}

}
