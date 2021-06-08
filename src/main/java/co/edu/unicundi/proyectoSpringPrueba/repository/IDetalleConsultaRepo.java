package co.edu.unicundi.proyectoSpringPrueba.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import co.edu.unicundi.proyectoSpringPrueba.entity.DetalleConsulta;

@Repository
public interface IDetalleConsultaRepo extends JpaRepository<DetalleConsulta, Integer> {

	
	@Query(value = "SELECT c FROM DetalleConsulta c")
	List<DetalleConsulta> buscarDConsultaOrdenar(Sort sort);
	
	List<DetalleConsulta> findByTratamientoAndDiagnostico(String tratamiento, String diagnostico);
	
	List<DetalleConsulta>findByDiagnosticoOrderByConsultaDesc(String diagnostico);
	
	
	//trae un detalle consulta que contenga ese doctor 
	List<DetalleConsulta> findByconsulta_nombreDoctor(String nombreDoctor);
}
