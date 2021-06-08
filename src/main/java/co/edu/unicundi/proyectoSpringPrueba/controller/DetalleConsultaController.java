package co.edu.unicundi.proyectoSpringPrueba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unicundi.proyectoSpringPrueba.entity.DetalleConsulta;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.service.IDetalleConsultaService;


@RestController
@RequestMapping("/DetalleConsulta")
public class DetalleConsultaController {

	
	@Autowired
	private IDetalleConsultaService service;
	
	@GetMapping("/retornar")
	public ResponseEntity<?> retornar() throws ModelNotFoundException  {
			List<DetalleConsulta> listaConsulta = service.retornar();
			return new ResponseEntity<List<DetalleConsulta>>(listaConsulta, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaPaginadoOrdenado/{page}/{size}/{ordenar}")
	public ResponseEntity<?> retornarPaginadoOrdenado(@PathVariable int page, @PathVariable int size,  @PathVariable String ordenar) throws ModelNotFoundException  {
			Page <DetalleConsulta> consultaPaginadoOrdenado = service.retornarDPaginadoOrdenado(page, size, ordenar);
			return new ResponseEntity <Page<DetalleConsulta>>(consultaPaginadoOrdenado, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaPaginado/{page}/{size}")
	public ResponseEntity<?> retornarPaginado(@PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page <DetalleConsulta> consultaPaginado = service.retornarDPaginado(page, size);
			return new ResponseEntity <Page<DetalleConsulta>>(consultaPaginado, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaOrdenado/{ordenar}")
	public ResponseEntity<?> retornarOrdenado(@PathVariable String ordenar) throws ModelNotFoundException  {
			 List<DetalleConsulta> consultaOrdenada = service.buscarDConsultaOrdenar(ordenar);
			return new ResponseEntity<List<DetalleConsulta>>(consultaOrdenada, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaTratamientoDiagnostico/{tratamiento}/{diagnostico}")
	public ResponseEntity<?> retornarTratamiento(@PathVariable String tratamiento, @PathVariable String diagnostico) throws ModelNotFoundException  {
			 List<DetalleConsulta> consultaTratamiento = service.retornarTratamientoDiagnostico(tratamiento, diagnostico );
			return new ResponseEntity <List<DetalleConsulta>>(consultaTratamiento, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaDiagnostico/{diagnostico}")
	public ResponseEntity<?> retornarDiagnostico(@PathVariable String diagnostico) throws ModelNotFoundException  {
			 List<DetalleConsulta> consultarDiagnostico = service.retornarDiagnostico(diagnostico);
			return new ResponseEntity <List<DetalleConsulta>>(consultarDiagnostico, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaDoctor/{nombreDoctor}")
	public ResponseEntity<?> retornarnombreDoctor(@PathVariable String nombreDoctor) throws ModelNotFoundException  {
			 List<DetalleConsulta> consultarNombreDoctor = service.retornarNombreDoctor(nombreDoctor);
			return new ResponseEntity <List<DetalleConsulta>>(consultarNombreDoctor, HttpStatus.OK);			
	}
	
	
	@GetMapping("/retornaId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException  {
			DetalleConsulta detalleConsulta = service.retornarPorId(id);
			return new ResponseEntity<DetalleConsulta>(detalleConsulta, HttpStatus.OK);			
	}	
	
	@PostMapping("/guardar/{id}")
	public ResponseEntity<?> guardar(@Valid @RequestBody DetalleConsulta detalleconsulta, @PathVariable int id)throws ModelNotFoundException {	
			service.guardar(detalleconsulta, id);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody DetalleConsulta detalleconsulta, @PathVariable int id) throws ModelNotFoundException {	
			service.editar(detalleconsulta, id);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}	
	
	@DeleteMapping("/eliminar/{id}") 
	public ResponseEntity<Object> elimianr(@PathVariable int id) throws ModelNotFoundException {
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}	
}
