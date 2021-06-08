package co.edu.unicundi.proyectoSpringPrueba.shedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


//configurar en el main del proyecto anotacion 
@Component
public class TareaSchedule {
	
	@Autowired
	//private IconsultaService service;
	
	@Scheduled(fixedRate = 60000)
	public void tarea1() {
		//service.eliminar();
		System.out.println("Hola UDEC!!!");
	}

}
