package co.edu.unicundi.proyectoSpringPrueba.dto;

import java.util.List;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.Examen;

public class ConsultaExamenDto {
	
	private Consulta consulta;
	
	private List <Examen> Examenes;
	
	private List<String> Infoadicional;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Examen> getExamenes() {
		return Examenes;
	}

	public void setExamenes(List<Examen> examenes) {
		Examenes = examenes;
	}

	public List<String> getInfoadicional() {
		return Infoadicional;
	}

	public void setInfoadicional(List<String> infoadicional) {
		Infoadicional = infoadicional;
	}
	
	

}
