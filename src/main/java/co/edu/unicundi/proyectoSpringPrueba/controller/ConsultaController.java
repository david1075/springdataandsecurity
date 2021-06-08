package co.edu.unicundi.proyectoSpringPrueba.controller;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.proyectoSpringPrueba.dto.ConsultaExamenDto;
import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.ConsultaExamen;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.service.IConsultaExamenService;
import co.edu.unicundi.proyectoSpringPrueba.service.IconsultaService;
import co.edu.unicundi.proyectoSpringPrueba.view.DetalleExamenView;

@RestController
@RequestMapping("/consulta")
@PreAuthorize("hasAuthority('administrador')")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ConsultaController  {

	
	@Autowired
	private IconsultaService service;
	
	@Autowired
	private IConsultaExamenService serviceConsultaExamen;
	
	//@PreAuthorize("hasAuthority('Doctor') OR hasAuthority('administrador')")
	@GetMapping("/retornar")
	public ResponseEntity<?> retornar() throws ModelNotFoundException  {
			List<Consulta> listaConsulta = service.retornar();
			return new ResponseEntity<List<Consulta>>(listaConsulta, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException  {
			Consulta consulta = service.retornarPorId(id);
			return new ResponseEntity<Consulta>(consulta, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaOrdenado/{ordenar}")
	public ResponseEntity<?> retornarOrdenado(@PathVariable String ordenar) throws ModelNotFoundException  {
			 List<Consulta> consultaOrdenada = service.buscarConsultaOrdenar(ordenar);
			return new ResponseEntity<List<Consulta>>(consultaOrdenada, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaDetalleTratamiento/{tratamiento}")
	public ResponseEntity<?> retornarTratamiento(@PathVariable String tratamiento) throws ModelNotFoundException  {
			 List<Consulta> consultaTratamiento = service.detalleConsultaTratamiento(tratamiento);
			return new ResponseEntity<List<Consulta>>(consultaTratamiento, HttpStatus.OK);			
	}
	
	
	@GetMapping("/retornaPaginado/{page}/{size}")
	public ResponseEntity<?> retornarPaginado(@PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page <Consulta> consultaPaginado = service.retornarPaginado(page, size);
			return new ResponseEntity <Page<Consulta>>(consultaPaginado, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaDoctorFecha/{nombreDoctor}/{fecha}")
	public ResponseEntity<?> retornarDoctorFecha(@PathVariable String nombreDoctor,@PathVariable String  fecha) throws ModelNotFoundException  {
			List<Consulta> consultaDoctorFecha = service.retornarDoctorFecha(nombreDoctor, fecha );
			return new ResponseEntity <List<Consulta>>(consultaDoctorFecha, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaPaginadoOrdenado/{page}/{size}/{ordenar}")
	public ResponseEntity<?> retornarPaginadoOrdenado(@PathVariable int page, @PathVariable int size,  @PathVariable String ordenar) throws ModelNotFoundException  {
			Page <Consulta> consultaPaginadoOrdenado = service.retornarPaginadoOrdenado(page, size, ordenar);
			return new ResponseEntity <Page<Consulta>>(consultaPaginadoOrdenado, HttpStatus.OK);			
	}	
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Consulta consulta) {	
			service.guardar(consulta);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@Valid @RequestBody Consulta consulta) throws ModelNotFoundException {	
			service.editar(consulta);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}	
	
	@DeleteMapping("/eliminar/{id}") 
	public ResponseEntity<Object> elimianr(@PathVariable int id) throws ModelNotFoundException {
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/guardarConsultaExamenNativo")
	public ResponseEntity<?> guardarConsultaExamenNativo(@Valid @RequestBody ConsultaExamen consultaExamen) {	
			serviceConsultaExamen.guardarNativo(consultaExamen);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}	
	
	@GetMapping("/listarCEPorIdCosnulta/{id}")
	public ResponseEntity<?> listarCEPorIdCosnulta(@PathVariable int id) throws ModelNotFoundException  {
			ConsultaExamenDto lista = serviceConsultaExamen.listarPorIdCosnulta(id);
			return new ResponseEntity <ConsultaExamenDto>(lista, HttpStatus.OK);			
	}	
	
	@GetMapping("/listarCEPorIdCosnultaPaginado/{id}/{page}/{size}")
	public ResponseEntity<?> listarCEPorIdCosnultaPaginado(@PathVariable int id,
			@PathVariable int page,
			@PathVariable int size ) throws ModelNotFoundException  {
			Page<ConsultaExamen> lista = serviceConsultaExamen.listarPorIdCosnultaPaginado(id, page, size);
			return new ResponseEntity<Page<ConsultaExamen>>(lista, HttpStatus.OK);			
	}
	
	@GetMapping("/listarCEPorIdView/{idConsulta}")
	public ResponseEntity<List<DetalleExamenView>> listarCEPorIdvista(@PathVariable Integer idConsulta){
		List<DetalleExamenView> listaCExamen = serviceConsultaExamen.listarExamenesPorIdConsulta(idConsulta);
		return new ResponseEntity<List<DetalleExamenView>>(listaCExamen, HttpStatus.OK);		
	}
	
	@GetMapping("/retornaCEPaginado/{page}/{size}")
	public ResponseEntity<?> retornarCEPaginado(@PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page <ConsultaExamen> consultaCEPaginado = serviceConsultaExamen.retornarPaginado(page, size);
			return new ResponseEntity <Page<ConsultaExamen>>(consultaCEPaginado, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaPaginadoOrdenadoCE/{page}/{size}/{ordenar}")
	public ResponseEntity<?> retornarPaginadoOrdenadoCE(@PathVariable int page, @PathVariable int size,  @PathVariable String ordenar) throws ModelNotFoundException  {
			Page <ConsultaExamen> consultaPaginadoOrdenadoCE = serviceConsultaExamen.retornarPaginadoOrdenado(page, size, ordenar);
			return new ResponseEntity <Page<ConsultaExamen>>(consultaPaginadoOrdenadoCE, HttpStatus.OK);			
	}	
	
	@PostMapping("/guardarCE")
	public ResponseEntity<?> guardarCE(@Valid @RequestBody ConsultaExamen consultaE) {	
			serviceConsultaExamen.guardar(consultaE);;
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
}
