package co.edu.unicundi.proyectoSpringPrueba.service;

import java.util.List;

import org.springframework.data.domain.Page;


import co.edu.unicundi.proyectoSpringPrueba.entity.DetalleConsulta;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IDetalleConsultaService {

	
	public DetalleConsulta retornarPorId(int id) throws ModelNotFoundException;
	
	public List<DetalleConsulta> retornar();
	
	public List<DetalleConsulta> buscarDConsultaOrdenar(String ordenar);
	
	public Page<DetalleConsulta> retornarDPaginado(Integer page, Integer size);
	
	public Page<DetalleConsulta> retornarDPaginadoOrdenado(Integer page, Integer size, String ordenar);
	
	public List <DetalleConsulta> retornarTratamientoDiagnostico(String tratamiento, String diagnostico);
	
	public List <DetalleConsulta> retornarDiagnostico(String diagnostico);
	
	public List<DetalleConsulta> retornarNombreDoctor(String nombreDoctor);
	
	public void guardar(DetalleConsulta detalleConsulta, Integer id)throws ModelNotFoundException;
	
	public void editar(DetalleConsulta detalleConsulta, Integer id) throws ModelNotFoundException;
	
	public void eliminar(Integer id) throws ModelNotFoundException;
}
