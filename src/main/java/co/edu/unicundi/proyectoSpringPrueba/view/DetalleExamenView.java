package co.edu.unicundi.proyectoSpringPrueba.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_examen_vista")
public class DetalleExamenView {
	
	private Integer idConsulta;
	
	@Id
	private Integer id;
	
	private String nombre;
	
	private String preparacion;
	
	private String descripcion;
	
	
	@Column(name = "info_adicional")
	private String infoAdicional;


	public Integer getIdConsulta() {
		return idConsulta;
	}


	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}


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


	public String getPreparacion() {
		return preparacion;
	}


	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getInfoAdicional() {
		return infoAdicional;
	}


	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	
	
	
	

}
