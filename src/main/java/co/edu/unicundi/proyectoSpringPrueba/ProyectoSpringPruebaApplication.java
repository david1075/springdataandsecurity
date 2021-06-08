package co.edu.unicundi.proyectoSpringPrueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProyectoSpringPruebaApplication {
	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		 return application.sources(ProyectoSpringPruebaApplication.class);
		 }

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringPruebaApplication.class, args);
	}

}
