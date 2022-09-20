package com.customer.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.commons.lang3.StringUtils;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Comparator;
import java.util.stream.Collectors;

@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Customers microservice")
                        .description("Service to handle customers.")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
