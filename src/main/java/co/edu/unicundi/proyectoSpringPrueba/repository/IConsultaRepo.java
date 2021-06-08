package co.edu.unicundi.proyectoSpringPrueba.repository;

import org.springframework.stereotype.Repository;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Sort;

@Repository
public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{
	
	//SQL nativa
	@Query(value = "select count(*) from consulta where id = :id", nativeQuery = true)
	Object cantidadObtenida(@Param("id") Integer Id);
	
	//JPQL
	// apuntando a los nombres del entity y poniendo alias
	@Query(value = "SELECT c FROM Consulta c WHERE c.nombreDoctor = :nombreDoctor")
	List<Consulta> buscarConsultaPorDoctor(@Param ("nombreDoctor") String nombreDoctor);
	
	@Query(value = "SELECT c FROM Consulta c WHERE c.nombreDoctor = :nombreDoctor")
	List<Consulta> buscarConsultaPorDoctorPaginado(@Param ("nombreDoctor") String nombreDoctor, Pageable pageable);
	
	@Query(value = "SELECT c FROM Consulta c")
	List<Consulta> buscarConsultaOrdenar(Sort sort);
	
	//nombramiento
	List <Consulta> findBynombreDoctor(String nombreDoctor);
	
	Page<Consulta>  findBynombreDoctor(String nombreDoctor, Pageable page);
	
	List <Consulta> findBynombreDoctorAndFecha(String nombreDoctor, Date fecha);
	
	
	// trae una consulta por el tratamiento que exista en detalleconsulta
	List <Consulta> findBydetalleConsulta_tratamiento(String tratamiento);
	
	

}
