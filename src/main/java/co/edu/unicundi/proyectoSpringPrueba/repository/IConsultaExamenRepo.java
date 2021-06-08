package co.edu.unicundi.proyectoSpringPrueba.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.ConsultaExamen;
import co.edu.unicundi.proyectoSpringPrueba.entity.Examen;
import co.edu.unicundi.proyectoSpringPrueba.view.DetalleExamenView;
public interface IConsultaExamenRepo  extends JpaRepository<ConsultaExamen, Integer>  {


	@Transactional
	@Modifying
	@Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen, info_adicional) values(:idConsulta, :idExamen, :infoAdicional)", nativeQuery = true)
	public void guardar(@Param("idConsulta") Integer idConsulta,@Param("idExamen") Integer idExamen, 
			@Param("infoAdicional") String infoAdicional);
	
	@Query(value = "from ConsultaExamen ce where ce.consulta.id = :idConsulta")
	List<ConsultaExamen> listarPorIdCosnulta(@Param("idConsulta")Integer idConsulta);
	
	@Query(value = "select examen.id, examen.nombre, examen.descripcion, examen.preparacion from examen inner join consulta_examen on examen.id = consulta_examen.id_examen where id_consulta = :idConsulta",  nativeQuery = true)
	List<Examen> listarExamenes(@Param("idConsulta")Integer idConsulta);
	
	@Query(value = "select distinct consulta.id, consulta.fecha, consulta.nombre_doctor from consulta inner join consulta_examen on consulta.id = consulta_examen.id_consulta where id_consulta = :idConsulta", nativeQuery = true)
	Consulta consulta(@Param("idConsulta")Integer idConsulta);
	
	@Query(value = " select info_adicional from consulta_examen  where id_consulta = :idConsulta", nativeQuery = true )
	List <String> listarInfoAdicional(@Param("idConsulta")Integer idConsulta);
	
	
	
	Page<ConsultaExamen> findByConsulta_Id(Integer id, Pageable page);
	
	
	@Query("SELECT dev FROM DetalleExamenView dev WHERE dev.idConsulta = :idConsulta")
	public List<DetalleExamenView> listarExamenesPorIdConsulta(@Param("idConsulta") Integer idConsulta);
	
	
}
