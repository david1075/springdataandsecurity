package co.edu.unicundi.proyectoSpringPrueba.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "rol")
public class Rol {

	@Id
	private Integer id;
	
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 30, nullable = false)
	private String apellido;
	
	@OneToMany(mappedBy = "rol", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
	List<Usuario> listaUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}	
	
	
	
}