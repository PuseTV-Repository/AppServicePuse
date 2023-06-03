package com.example.ApiAppv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiAppv2Application {
    
    @GetMapping("/mensaje")
    public String mensaje() {
        return "Conexión exitosa";
    }

	public static void main(String[] args) {
		SpringApplication.run(ApiAppv2Application.class, args);
	}

}
