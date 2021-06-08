package co.edu.unicundi.proyectoSpringPrueba.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.proyectoSpringPrueba.entity.Medico;

@Repository
public interface IMedicoRepo extends JpaRepository<Medico, Integer>{

	@Query(value = "select count(*) from medico where id = :id", nativeQuery  = true)
	Object cantidadObtenida(@Param("id") Integer id);
	
	Page<Medico>  findBynombre(String nombreDoctor, Pageable page);
	
	Page <Medico> findByApellidoIgnoreCaseOrderByNombreAsc(String apellido, Pageable page);
	
	Medico findBycorreo(String correo);
	
	Medico findByDireccion_detalle(@Param("detalle")String detalle);
	
	Page <Medico> findByDireccion_ciudadIgnoreCaseOrderByDireccion_barrioAsc(@Param("ciudad")String ciudad, Pageable page);
	
	Page <Medico> findByDireccion_paisIgnoreCaseOrderByDireccion_ciudadAsc(@Param("pais")String pais, Pageable page);
	
	Page <Medico> findByDireccion_barrioIgnoreCaseOrderByNombreAsc(@Param("barrio")String barrio, Pageable page);
	
	
	
		
	
}
