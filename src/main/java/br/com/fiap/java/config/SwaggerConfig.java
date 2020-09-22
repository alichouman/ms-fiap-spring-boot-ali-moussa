package br.com.fiap.java.config;

import org.springframework.beans.factory.annotation.Value;
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
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${pom.description}")
	private String description;

	@Value("${pom.version}")
	private String version;

	@Value("${pom.name}")
	private String name;

	@Value("${swagger.author}")
	private String author;

	@Value("${swagger.site}")
	private String site;

	@Value("${swagger.email}")
	private String email;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.fiap.java.controller")).paths(PathSelectors.any())
				.build().useDefaultResponseMessages(false).apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(name).description(description).version(version)
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(new Contact(author, site, email)).build();
	}

}