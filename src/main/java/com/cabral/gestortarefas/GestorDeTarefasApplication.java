package com.cabral.gestortarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestorDeTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorDeTarefasApplication.class, args);
	}

}
