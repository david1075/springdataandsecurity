package co.edu.unicundi.proyectoSpringPrueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "cedula es obligatoria")
	@Size(min = 7, max = 10, message = "cedula debe tener entre 7 y 10 numeros")
	@Column(name = "cedula", length = 10, unique = true, nullable = false)
	private String cedula;
	
	@NotNull(message = "nombre es obligatorio")
	@Size(max = 25, message = "nombre maximo de 25 letras")
	@Column(name = "nombre", length = 25, nullable = false)
	private String nombre;
	
	@NotNull(message = "apellido es obligatorio")
	@Size(max = 25, message = "apellido maximo de 25 letras ")
	@Column(name = "apellido", length = 25, nullable = false)
	private String apellido;
	
	
	@NotNull(message = "correo obligatorio")
	@Size(max = 60, message = "correo maximo de 60 caracteres")
	@Column(name = "correo", length = 60, nullable = false)
	private String correo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
