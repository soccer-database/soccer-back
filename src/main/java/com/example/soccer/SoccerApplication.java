package com.example.soccer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "https://stable-redbird-sunny.ngrok-free.app")})
public class SoccerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoccerApplication.class, args);
    }

}
