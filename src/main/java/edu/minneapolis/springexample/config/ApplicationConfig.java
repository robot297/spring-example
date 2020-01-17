package edu.minneapolis.springexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("edu.minneapolis.springexample")
@PropertySources({ @PropertySource(value = {"application.properties"}, ignoreResourceNotFound = true)})
public class ApplicationConfig {

    @Autowired
    Environment env;

    @Value("springexample")
    String appName;

    @Bean
    public ApplicationProperties properties(){
        return new ApplicationProperties();
    }
}
