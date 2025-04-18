package com.UdeSantiago.GestionInventario.Config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

    public OpenAPI customOpenAPI(){
                        .title("API gestion de productos")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Santiago Ude")
                                .email("santiagoude8@gmail.com")
                                .url("https://github.com/santiago-ude")));
    }


}
