package com.java.circle.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableJpaRepositories(basePackages = {"com.java.circle.practice.api.repository"})
@EntityScan(basePackages = {"com.java.circle.practice.api.model"})
@EnableSwagger2
@SpringBootApplication
public class PracticeApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket ( DocumentationType.SWAGGER_2 )
				.select ()
				.apis ( RequestHandlerSelectors.basePackage ("com.java.circle.practice") )
				.paths ( PathSelectors.any () )
				.build ()
				.apiInfo ( apiInfo() );
	}

	private ApiInfo apiInfo() {
		return new ApiInfo ( "Spring practice",
				"Spring practice Task",
				"1.0.0",
				"All rights reserved",
				new Contact ( "Britto", "https://www.linkedin.com/in/britto-m-33345740/", "britto.doss@hotmail.com" ),
				"2018",
				"https://www.linkedin.com/in/britto-m-33345740/",
				Collections.emptyList());
	}
}
