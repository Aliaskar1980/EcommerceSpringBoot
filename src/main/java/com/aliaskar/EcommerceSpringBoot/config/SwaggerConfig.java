package com.aliaskar.EcommerceSpringBoot.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

/**
 * Created by Admin on 24.04.2022
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI eCommerce(){
        return new OpenAPI()
                .info(
                        new Info()
                        .title("ECommerce application for frontend team")
                        .version("3.0.2")
                        .contact(
                                new Contact()
                                .name("Aliaskar")

                        )
                );

    }

}
