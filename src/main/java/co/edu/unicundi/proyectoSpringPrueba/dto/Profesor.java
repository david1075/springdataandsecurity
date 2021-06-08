package co.edu.unicundi.proyectoSpringPrueba.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "clase profesor dto que almacena los atributos utilizados por la clase profesor")
public class Profesor {
	
	

	@ApiModelProperty(position = 0,
				notes = "atributo que almacena el id unico de cada profesor")
	private Integer id;
	
	@ApiModelProperty(position = 3,
				notes = "atributo que almacena la cedula de cada profesor")
	private String cedula;
	
	@ApiModelProperty(position = 1,
				notes = "atributo que almacena el nombre de cada profesor")
	private String nombre;
	
	@ApiModelProperty(position = 2,
				notes = "atributo que almacena el apellido de cada profesor")
	private String apellido;
	
	
	public Profesor() {
		
	}

	

	public Profesor(Integer id, String cedula, String nombre, String apellido) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}



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
	
	
}
