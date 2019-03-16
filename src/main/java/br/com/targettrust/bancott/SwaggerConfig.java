package br.com.targettrust.bancott;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		HashSet<String> consumesEProducers = 
				new HashSet<>(Arrays.asList("application/json"));
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.consumes(consumesEProducers)
				.produces(consumesEProducers).pathMapping("/");
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Banco TT")
				.description("Api para consumo de serviços")
				.version("1.0")
				.contact(new Contact("Rafael", 
						"http://targettrust.com.br", 
						"rafaelldanieli@gmail.com"))
				.license("Apache 2.0")
				.build();
	}
	
}
