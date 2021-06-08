package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IProfesorService {
	
	public Profesor retornarPorId(int id) throws ModelNotFoundException;
	
	public List<Profesor> retornar();
	
	public void guardar(Profesor profesor);
	
	public void editar(Profesor profesor) throws ModelNotFoundException;
	
	public void eliminar(Integer id) throws ModelNotFoundException;

	
	
}
