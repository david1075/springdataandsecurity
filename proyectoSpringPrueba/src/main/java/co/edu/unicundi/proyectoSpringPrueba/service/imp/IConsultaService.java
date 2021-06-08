package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IConsultaService {

	public Consulta retornarPorId(int id) throws ModelNotFoundException;
	
	public List<Consulta> retornar();
	
	public void guardar(Consulta consulta);
	
	public void editar(Consulta consulta) throws ModelNotFoundException;
	
	public void eliminar(Integer id) throws ModelNotFoundException;
}
