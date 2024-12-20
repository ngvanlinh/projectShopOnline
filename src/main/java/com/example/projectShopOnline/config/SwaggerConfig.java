package com.example.projectShopOnline.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Full Stack Tutorial",
                version = "1.0",
                description = "API Documentation for spring boot full stack"
        )

)
public class SwaggerConfig {
}
