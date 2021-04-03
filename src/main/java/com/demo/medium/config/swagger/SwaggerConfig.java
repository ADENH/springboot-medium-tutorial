package com.demo.medium.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Date: Apr 3, 2021
 * Time: 11:06:18 AM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(getApiInfo())
        		.select()
        		.apis(RequestHandlerSelectors.any())
        		.paths(PathSelectors.any())                          
        		.build();                                           
    }
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Spring Boot Tutorial")
				.description("Dokumentasi API for developers")
				.termsOfServiceUrl("http://adenurhidayat.com")
				.contact(getContact()).license("adenurhidayat License")
				.licenseUrl("ade.enhaa@gmail.com").version("1.0").build();
	}
	
	private Contact getContact() {
		return new Contact("Ade Nur Hidayat", "adenurhidayat.com", "ade.enhaa@gmail.com");
	}
}
