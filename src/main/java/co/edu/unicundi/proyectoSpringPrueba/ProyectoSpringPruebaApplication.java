package co.edu.unicundi.proyectoSpringPrueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProyectoSpringPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringPruebaApplication.class, args);
	}

}
