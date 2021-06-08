package co.edu.unicundi.proyectoSpringPrueba.dto;

public class Universidad {
	
	private String nombreU;
	
	public Universidad () {
		
	}

	public Universidad(String nombreU) {
		super();
		this.nombreU = nombreU;
	}

	public String getNombreU() {
		return nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

}
