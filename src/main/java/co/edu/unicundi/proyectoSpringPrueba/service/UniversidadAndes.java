package co.edu.unicundi.proyectoSpringPrueba.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.dto.Universidad;

@Service
@Qualifier("andes")
public class UniversidadAndes implements IUniversidad{

	
	@Override
	public Universidad retornarinfo() {
		Universidad uni = new Universidad("universidad andes");
		return uni;
		
	}	

}
