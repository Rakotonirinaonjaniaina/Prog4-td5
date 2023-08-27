package com.example.prog4;

import com.example.prog4.service.AuthService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prog4Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Prog4Application.class, args);

		AuthService authService = context.getBean(AuthService.class);

		authService.insertUser("onja", "1234");
	}

}