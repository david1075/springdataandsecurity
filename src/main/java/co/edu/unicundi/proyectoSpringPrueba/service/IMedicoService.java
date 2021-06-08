package co.edu.unicundi.proyectoSpringPrueba.service;

import org.springframework.data.domain.Page;


import co.edu.unicundi.proyectoSpringPrueba.entity.Medico;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IMedicoService extends ICrud<Medico, Integer> {

	public Page <Medico> retornarnombremedico(String nombre, Integer page, Integer size) throws ModelNotFoundException;
	
	public Page <Medico> retornarApellido(String Apellido, Integer page, Integer size);
	
	public Medico retornarCorreo(String correo);
	
	public Medico RetornarDireccionDetalle(String detalle);
	
	public Page <Medico> retornarDireccionCiudad(String ciudad, Integer page, Integer size);
	
	public Page <Medico> retornarDireccionPais(String pais, Integer page, Integer size);
	
	public Page <Medico> retornarDireccionBarrio(String barrio, Integer page, Integer size);
}
