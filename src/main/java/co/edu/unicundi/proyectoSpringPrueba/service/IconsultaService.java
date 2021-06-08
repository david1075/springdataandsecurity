package co.edu.unicundi.proyectoSpringPrueba.service;




import java.util.List;

import org.springframework.data.domain.Page;


import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;


public interface IconsultaService extends ICrud<Consulta, Integer> {

	
	public List<Consulta> retornar();
	
	public List <Consulta> retornarDoctorFecha(String nombreDoctor, String fecha);
	
	public List<Consulta> buscarConsultaOrdenar(String ordenar);
	
	public List<Consulta> detalleConsultaTratamiento(String tratamiento);
	
	public Page<Consulta> retornarPaginado(Integer page, Integer size);
	
	public Page<Consulta> retornarPaginadoOrdenado(Integer page, Integer size, String ordenar);
	
	
}

