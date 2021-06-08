package co.edu.unicundi.proyectoSpringPrueba.service;

import java.util.List;

import org.springframework.data.domain.Page;

import co.edu.unicundi.proyectoSpringPrueba.dto.ConsultaExamenDto;
import co.edu.unicundi.proyectoSpringPrueba.entity.ConsultaExamen;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.view.DetalleExamenView;

public interface IConsultaExamenService extends ICrud<ConsultaExamen, Integer> {
	
	public void guardarNativo(ConsultaExamen consultaExamen);
	
	public ConsultaExamenDto listarPorIdCosnulta(Integer idConsulta) throws ModelNotFoundException;
	
	Page<ConsultaExamen> listarPorIdCosnultaPaginado(Integer id, Integer page, Integer size);	
	
	public List<DetalleExamenView> listarExamenesPorIdConsulta(Integer idConsulta);

}
