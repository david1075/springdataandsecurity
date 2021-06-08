package co.edu.unicundi.proyectoSpringPrueba.service;
import org.springframework.data.domain.Page;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;


public interface ICrud<T,V> {
	
	public T retornarPorId(V id) throws ModelNotFoundException;
	
	public Page<T> retornarPaginado(Integer page, Integer size);
	
	public Page<T> retornarPaginadoOrdenado(Integer page, Integer size, String ordenar);
	
	public void guardar(T entity);
	
	public void editar(T entity) throws ModelNotFoundException;
	
	public void eliminar(V id) throws ModelNotFoundException;	


}
