package co.edu.unicundi.proyectoSpringPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;

@Repository
public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{

	
	
}
