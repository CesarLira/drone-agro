package br.com.fiap.droneagro;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class DroneAgroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneAgroApplication.class, args);
	}

}
