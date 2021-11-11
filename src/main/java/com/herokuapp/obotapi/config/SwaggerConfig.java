package com.herokuapp.obotapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Import(BeanValidatorPluginsConfiguration.class)
@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("Obot Sample Spring App")
                .description("This lists all the movie endpoints.")
                .version("1.0")
                .contact(new Contact("Daniel Obot", "https://github.com/robot297","danobot@hotmail.com"))
                .build();
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.herokuapp.obotapi"))
                .paths(PathSelectors.ant("/movie/**"))
                .build();
    }
}
