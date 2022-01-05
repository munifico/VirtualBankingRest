package com.jsikmc15.virtualbankingrest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport{
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
//				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jsikmc15.virtualbankingrest"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	//Swagger UI 화면 정보 설정(제목, 설명 등 문서에 대한 정보)
		private ApiInfo apiInfo() {
			/*
			  String title,
		      String description,
		      String version,
		      String termsOfServiceUrl,
		      Contact contact,
		      String license,
		      String licenseUrl,
		      Collection<VendorExtension> vendorExtensions
			 */
			/*
			return new ApiInfo(
					"REST API Documentation",
	                "OpenApi 사용 설명서입니다",  
	                "1.0",                                           
	                "localhost:9090",
	                new Contact("Choi Cheol Hwan","http://choi.com","hwanyhee@naver.com"), 
	                "CCH 2.0", 
	                "https://springfox.github.io",
	                new ArrayList<VendorExtension>());
			*/
	        return new ApiInfoBuilder()       		
	                .title("REST API Documentation")
	                .description("Virtual Bank OpenApi 사용 설명서입니다")
	                .version("1.0")                
	                .termsOfServiceUrl("localhost:8950")               
	                .contact(new Contact("jsik","https://j-sik.tistory.com/", "officialyoonsic@gmail.com"))            
	                .license("CCH 2.0")
	                .licenseUrl("https://github.com/ychic/Spring-RestAPI-Test")
	                .extensions(new ArrayList<VendorExtension>())
	                .build();
		}


}
