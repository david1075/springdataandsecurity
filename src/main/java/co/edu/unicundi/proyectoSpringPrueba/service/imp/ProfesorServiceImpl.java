package co.edu.unicundi.proyectoSpringPrueba.service.imp;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.CedulaDuplicadaException;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IProfesorRepo;
import co.edu.unicundi.proyectoSpringPrueba.service.IProfesorService;

@Service
public class ProfesorServiceImpl implements IProfesorService {
	
	@Autowired
	private IProfesorRepo profesorRepo;
	
	
	@Override
	public List<Profesor> retornar() {
		return profesorRepo.findAll();
		
	}

	@Override
	public Profesor retornarProfesor(Integer id) throws ModelNotFoundException {
		/*Optional <Profesor> op = profesorRepo.findById(id);
		return op.isPresent() ? op.get() : null;*/
		
		Profesor profesor = profesorRepo.findById(id).orElseThrow(
				() -> new ModelNotFoundException ("Profesor no encontrado"));
		return profesor;
	}

	@Override
	public void editar(Profesor profesor) throws CedulaDuplicadaException, ModelNotFoundException {
	
		int cedulaExistente = profesorRepo.countByCedula(profesor.getCedula());
		if(cedulaExistente == 0) {
			Profesor profesorAux = new Profesor();
			profesorAux = retornarProfesor(profesor.getId());
			profesorAux.setNombre(profesor.getNombre());
			profesorAux.setApellido(profesor.getApellido());
			profesorAux.setCorreo(profesor.getCorreo());
			profesorRepo.save(profesorAux);
		}else {
			throw new CedulaDuplicadaException ("cedula duplicada");
		}	
				
	}
		
		
	

	@Override
	public void guardar(Profesor profesor) throws CedulaDuplicadaException {
		
		int cedulaExistente = profesorRepo.findByCedulaSql(profesor.getCedula());
		if(cedulaExistente == 0) {
				profesor.setId(null);
				profesorRepo.save(profesor);
		}else {
			throw new CedulaDuplicadaException ("cedula duplicada");
		}
		
		
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		Profesor profesorAux = new Profesor();
		profesorAux = retornarProfesor(id);
		profesorRepo.delete(profesorAux);
		
	}

}
