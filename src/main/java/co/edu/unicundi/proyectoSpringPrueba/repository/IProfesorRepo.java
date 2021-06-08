package co.edu.unicundi.proyectoSpringPrueba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;

@Repository
public interface IProfesorRepo  extends JpaRepository <Profesor, Integer> {

	//nombramiento
	@Transactional(readOnly = true)
	int countByCedula(String cedula);
	
	
	//jpql
	@Query("SELECT COUNT(p) FROM Profesor p WHERE p.cedula = ?1")
	int EncontrarPorCedula(String cedula);
	
	//sql
	@Query(
			value = "SELECT COUNT (p) FROM Profesor p WHERE p.cedula = ?1", 
			nativeQuery = true)
			int findByCedulaSql(String cedula);
}
