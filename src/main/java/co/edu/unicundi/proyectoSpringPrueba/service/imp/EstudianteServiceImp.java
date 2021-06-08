package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.dto.Estudiante;
import co.edu.unicundi.proyectoSpringPrueba.service.IEstudianteService;
import co.edu.unicundi.proyectoSpringPrueba.service.IUniversidad;

@Service
public class EstudianteServiceImp implements IEstudianteService{

	@Autowired
	@Qualifier("cundi")
	private IUniversidad universidadService;
	
	
	
	@Override
	public Estudiante retornaInfo() {
		Estudiante estudiante = new Estudiante(1073, "David", "Jimenez Guerrero");
		estudiante.setUniversidad(universidadService.retornarinfo());
		return estudiante;
	}

}
