package com.ciclo3.juanparra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@EntityScan(basePackages = {"com.ciclo3.juanparra.model"})
@SpringBootApplication

public class JuanparraApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuanparraApplication.class, args);
	}

}
