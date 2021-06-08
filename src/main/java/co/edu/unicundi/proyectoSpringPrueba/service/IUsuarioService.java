package co.edu.unicundi.proyectoSpringPrueba.service;


import org.springframework.data.domain.Page;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.Usuario;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IUsuarioService {

	
	public Consulta retornarPorId(int id) throws ModelNotFoundException;
	
	public Page<Usuario> retornarPaginado(Integer page, Integer size);
	
	public Page<Usuario> retornarPaginadoOrdenado(Integer page, Integer size, String ordenar);
	
	public void guardar(Usuario usuario);
	
	public void editar(Usuario usuario) throws ModelNotFoundException;
	
	public void cambiarEstado(Integer id) throws ModelNotFoundException;
}
