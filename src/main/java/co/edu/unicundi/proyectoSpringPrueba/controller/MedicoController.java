package co.edu.unicundi.proyectoSpringPrueba.controller;

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

import co.edu.unicundi.proyectoSpringPrueba.entity.Medico;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.service.IMedicoService;





@RestController
@RequestMapping("/medicos")
public class MedicoController {

	

	@Autowired
	private IMedicoService service;
	
	@GetMapping("/retornaPorId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException  {
			Medico medico = service.retornarPorId(id);
			return new ResponseEntity<Medico>(medico, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornarPaginado/{page}/{size}")
	public ResponseEntity<?> retornarPaginado(@PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page<Medico> consultaPaginada = service.retornarPaginado(page, size);
			return new ResponseEntity<Page<Medico>>(consultaPaginada, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornarnombre/{nombre}/{page}/{size}")
	public ResponseEntity<?> retornarnombre(@PathVariable String nombre, @PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page<Medico> consultaNombre = service.retornarnombremedico(nombre, page, size);
			return new ResponseEntity<Page<Medico>>(consultaNombre, HttpStatus.OK);			
	}
	
	@GetMapping("/retornarapellido/{apellido}/{page}/{size}")
	public ResponseEntity<?> retornarapellido(@PathVariable String apellido, @PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page<Medico> consultaApellido = service.retornarApellido(apellido, page, size);
			return new ResponseEntity<Page<Medico>>(consultaApellido, HttpStatus.OK);			
	}
	
	@GetMapping("/retornarcorreo/{correo}")
	public ResponseEntity<?> retornarcorreo(@PathVariable String correo) throws ModelNotFoundException  {
			Medico consultaCorreo = service.retornarCorreo(correo);
			return new ResponseEntity<Medico>(consultaCorreo, HttpStatus.OK);			
	}
	
	@GetMapping("/retornardetalle/{detalle}")
	public ResponseEntity<?> retornardetalle(@PathVariable String detalle) throws ModelNotFoundException  {
			Medico consultaDetalle = service.RetornarDireccionDetalle(detalle);
			return new ResponseEntity<Medico>(consultaDetalle, HttpStatus.OK);
	}
	
	@GetMapping("/retornarciudad/{ciudad}/{page}/{size}")
	public ResponseEntity<?> retornarciudad(@PathVariable String ciudad, @PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page<Medico> consultaCiudad = service.retornarDireccionCiudad(ciudad, page, size);
			return new ResponseEntity<Page<Medico>>(consultaCiudad, HttpStatus.OK);			
	}
	
	@GetMapping("/retornarpais/{pais}/{page}/{size}")
	public ResponseEntity<?> retornarpais(@PathVariable String pais, @PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page<Medico> consultaPais = service.retornarDireccionPais(pais, page, size);
			return new ResponseEntity<Page<Medico>>(consultaPais, HttpStatus.OK);			
	}
	
	@GetMapping("/retornarbarrio/{barrio}/{page}/{size}")
	public ResponseEntity<?> retornarbarrio(@PathVariable String barrio, @PathVariable int page, @PathVariable int size) throws ModelNotFoundException  {
			Page<Medico> consultaBarrio = service.retornarDireccionBarrio(barrio, page, size);
			return new ResponseEntity<Page<Medico>>(consultaBarrio, HttpStatus.OK);			
	}
	
	@GetMapping("/retornarPaginadoOrdenado/{page}/{size}/{ordenado}")
	public ResponseEntity<?> retornarPaginadoOrdenado(@PathVariable int page, @PathVariable int size, @PathVariable String ordenado) throws ModelNotFoundException  {
			Page<Medico> consultaPaginada = service.retornarPaginadoOrdenado(page, size, ordenado);
			return new ResponseEntity<Page<Medico>>(consultaPaginada, HttpStatus.OK);			
	}	
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Medico medico) {	
			service.guardar(medico);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@Valid @RequestBody Medico medico) throws ModelNotFoundException {	
			service.editar(medico);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}	
	
	@DeleteMapping("eliminar/{id}") 
	public ResponseEntity<Object> elimianr(@PathVariable Integer id) throws ModelNotFoundException {
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}
}
