package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IProfesorRepo;

@Service
public class ProfesorServiceImp implements IProfesorService{

	
	@Autowired
	private IProfesorRepo profesorRepo;
	
	@Override
	public Profesor retornarPorId(int id) throws ModelNotFoundException {
		/*Optional<Profesor> op = profesorRepo.findById(id);
		return op.isPresent() ? op.get() : null;*/
		
		Profesor profesor = profesorRepo.findById(id).orElseThrow(
				() -> new ModelNotFoundException("Profesor no exontrado"));
		return profesor;					
	}

	@Override
	public List<Profesor> retornar() {
		return profesorRepo.findAll();
	}	
		
	@Override
	public void guardar(Profesor profesor)  {		
		this.profesorRepo.save(profesor);
		//return pro;
	}
	
	@Override
	public void editar(Profesor profesor) throws ModelNotFoundException {
		Profesor pro = this.retornarPorId(profesor.getId());
		pro.setApelido(profesor.getApelido());
		pro.setNombre(profesor.getNombre());
		pro.setCorreo(profesor.getCorreo());
		pro.setEdad(profesor.getEdad());
		//pro.setCedula(profesor.getCedula());		
		this.profesorRepo.save(pro);	
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}
	


}
