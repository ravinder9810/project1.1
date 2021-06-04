package com.demo;

//import org.springframework.cglib.core.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class Swagger {
	
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
						.groupName("USer-api")
						.apiInfo(apiInfo()).select().
						paths(postPaths()).build();
	}
	private Predicate<String> postPaths(){
		return or(regex("/registration/.*"), regex("/registration/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("USer Api")
				.description( " APi reference for developers ")
				.termsOfServiceUrl("http://ravi.com").license("ravinder licence")
				.licenseUrl("ravinder@mail.com").version("1.0").build();
	}
	
}
