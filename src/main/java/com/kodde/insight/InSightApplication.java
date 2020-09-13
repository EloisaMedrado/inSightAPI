package com.kodde.insight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableCaching
@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InSightApplication {
	
	@Value("${kodde.insight.allowedOrigin}")
	private String allowedOrigin;
	
	@Value("${kodde.insight.allowedHeaders}")
	private String allowedHeaders;
	
	@Value("${kodde.insight.maxAge}")
	private Long maxAge;
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/insight/weather")
                		.allowedOrigins(allowedOrigin)
                		.allowedHeaders(allowedHeaders)
                		.maxAge(maxAge);
            }
        };
    }
    
    public static void main( String[] args ) {
    	SpringApplication.run(InSightApplication.class, args);
    }
}
