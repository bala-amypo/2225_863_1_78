package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;





@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Skill Based Volunteer Task Assignor API")
                .version("1.0")
                .description("API for managing volunteer task assignments based on skills"))
            .servers(List.of(
                new Server().url("https://9116.32procr.amypo.ai/")
            ));
    }
  
}
