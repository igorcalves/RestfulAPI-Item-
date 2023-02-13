package br.com.igor.Itens.endpointsPort.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
            .info(new Info()
                .title("My first Api Restful With Swagger, java 19 and Spring boot 3.0.2")
                .version("v1")
                .description("api with, Hateoas, swagger content Negotiation")
                .termsOfService("hhtp://pub.igor.com.br/terms")
                .license(
                    new License()
                        .name("apache 2.0")
                        .url("https//pub.igor.com.br/SpringRestful-Itens")
                        ));   
    }
    
}
