package co.edu.unicundi.proyectoSpringPrueba.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.service.imp.IProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	private IProfesorService profesorService;
	
	//No utilizar
	@RequestMapping(value = "/retonarNombre", method = RequestMethod.GET)
	public String retornarNombre() {
		return "Johans ";
		
	}
	
	/*@GetMapping("/retornar")
	public ResponseEntity<List<Profesor>> retornar(){
		List<Profesor> listaProfesor = new ArrayList<>();
		listaProfesor.add(new Profesor(21, "Johans", "González"));
		listaProfesor.add(new Profesor(1, "Francisco", "Lanza"));
		listaProfesor.add(new Profesor(2, "Oscar", "Morera"));
		return new ResponseEntity<List<Profesor>>(listaProfesor, HttpStatus.OK);
	}*/
	
	@GetMapping("/retornaPorId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException  {
			Profesor profesor = profesorService.retornarPorId(id);
			return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);			
	}	
	
	
	

	@GetMapping("/retornarApellido")
	public ResponseEntity<String> retornarApellido() {		
		return new ResponseEntity<String>("González", HttpStatus.OK);		
		//return ResponseEntity.ok("González").getHeaders().
		
	}
	
	@GetMapping("/retornarInfo/{nombre}/{apellido}")
	public ResponseEntity<String> retornarInfo(	@PathVariable String nombre, 
								@PathVariable String apellido) {
		//return nombre + " " + apellido;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom", "Texto");
		headers.add("Custom2", "Texto2");
		return new ResponseEntity<String>(nombre + " " + apellido, headers,  HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Profesor profesor) {	
			profesorService.guardar(profesor);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	/*@PutMapping("editar/{var}")
	public Profesor editar(	@PathVariable int var,
							@RequestBody Profesor profesor) {
		System.out.println(var + " " + profesor.getId() + " " + profesor.getNombre() + " " + profesor.getApellido());
		return profesor;
	}*/
	
	@DeleteMapping("eliminar/{id}") 
	public ResponseEntity<Object> elimianr(@PathVariable int id) {
		System.out.println(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}

}
