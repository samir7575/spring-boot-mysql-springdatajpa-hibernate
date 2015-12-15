package com.softdesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicates;
import com.softdesign.controller.UserController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = { UserController.class })
public class Application
{

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApiInfo apiInfo()
	{
		ApiInfo apiInfo = new ApiInfo(
			"Mikzo REST API",
			"",
			"2.2.2",
			"",
			"",
			"",
			"");
		return apiInfo;
	}

	@Bean
	public Docket customImplementation()
	{
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo())
			.select()
			.paths(Predicates.not(PathSelectors.regex("/error"))) // Exclude Spring error controllers
			.build();
	}

	// @Bean
	// public Docket petApi()
	// {
	// List<ResponseMessage> responseMessages = new ArrayList<>();
	// responseMessages.add(
	// new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build());
	//
	// List<SecurityScheme> listApiKey = new ArrayList<>();
	// listApiKey.add(apiKey());
	//
	// List<SecurityContext> listSecurityContext = new ArrayList<>();
	// listSecurityContext.add(securityContext());
	//
	// return new Docket(DocumentationType.SWAGGER_2)
	// .select().apis(RequestHandlerSelectors.any())
	// .paths(PathSelectors.any())
	// .build()
	// .pathMapping("/")
	// // .directModelSubstitute(LocalDate, with)
	// .genericModelSubstitutes(ResponseEntity.class)
	// .alternateTypeRules(new AlternateTypeRule(typeResolver.resolve(DeferredResult.class,
	// typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
	// typeResolver.resolve(WildcardType.class)))
	// .useDefaultResponseMessages(false)
	// .useDefaultResponseMessages(false)
	// .globalResponseMessage(RequestMethod.GET, responseMessages)
	// .securitySchemes(listApiKey).securityContexts(listSecurityContext);
	//
	// }
	//
	// @Autowired
	// private TypeResolver typeResolver;
	//
	// private ApiKey apiKey()
	// {
	// return new ApiKey("mykey", "api_key", "header");
	// }
	//
	// private SecurityContext securityContext()
	// {
	// return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*"))
	// .build();
	// }
	//
	// List<SecurityReference> defaultAuth()
	// {
	// AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	// AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	// authorizationScopes[0] = authorizationScope;
	// List<SecurityReference> securityReferences = new ArrayList<>();
	// securityReferences.add(new SecurityReference("mykey", authorizationScopes));
	// return securityReferences;
	// }
	//
	// @Bean
	// SecurityConfiguration security()
	// {
	// return new SecurityConfiguration("test-app-client-id", "test-app-realm", "test-app", "apiKey");
	// }
	//
	// @Bean
	// UiConfiguration uiConfig()
	// {
	// return new UiConfiguration("validatorUrl");
	// }
}
