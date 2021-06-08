package co.edu.unicundi.proyectoSpringPrueba.service;

import java.util.List;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.CedulaDuplicadaException;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IProfesorService {

	public List<Profesor> retornar();
	public Profesor retornarProfesor(Integer id) throws ModelNotFoundException;
	public void editar(Profesor profesor) throws CedulaDuplicadaException, ModelNotFoundException;
	public void guardar(Profesor profesor)throws  CedulaDuplicadaException;
	public void eliminar(Integer id) throws ModelNotFoundException;

}
