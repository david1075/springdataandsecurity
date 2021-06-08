package co.edu.unicundi.proyectoSpringPrueba.dto;


public class Estudiante {

	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String nombreUni;
	
	private Universidad universidad;
	
	public Estudiante() {
		
	}
	
	public Estudiante(Integer id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public String getNombreUni() {
		return nombreUni;
	}

	public void setNombreUni(String nombreUni) {
		this.nombreUni = nombreUni;
	}
	
	
		
}