package co.edu.unicundi.proyectoSpringPrueba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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


import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.CedulaDuplicadaException;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.service.IProfesorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	private IProfesorService ProfesorService;
	
	/*//No utilizar
	@RequestMapping(value = "/retonarNombre", method = RequestMethod.GET)
	public String retornarNombre() {
		return "Johans ";
		
	}*/
	
	@ApiOperation(value = "Retornar lista de profesores"
            	,notes = "Este servicio retorna una lista de profesores previamente creada en el sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Profesor.class ),
            @ApiResponse(code = 401, message = "UNAUTHORIZED. Es necesario autenticar para obtener la respuesta solicitada"),
            @ApiResponse(code = 403, message = "FORBIDDEN. El cliente no posee los permisos necesarios para cierto contenido"),
            @ApiResponse(code = 404, message = "NOT FOUND. recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	
	//@GetMapping(path = "/retornarApellido", produces = "application/xml")
	@GetMapping("/retornar")
	public ResponseEntity<List<Profesor>> retornar() {
		List<Profesor> profesor = ProfesorService.retornar();
		return new ResponseEntity<List<Profesor>>(profesor, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna un profesor"
        		,notes = "Este servicio retorna un profesor solicitado por el usuario con el numero unico identificativo id")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Profesor.class ),
	        @ApiResponse(code = 401, message = "UNAUTHORIZED. Es necesario autenticar para obtener la respuesta solicitada"),
	        @ApiResponse(code = 403, message = "FORBIDDEN. El cliente no posee los permisos necesarios para cierto contenido"),
	        @ApiResponse(code = 404, message = "NOT FOUND. recurso no encontrado"),
	        @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping("/retornarId/{id}")
	public ResponseEntity <Profesor> retornarProfesor(	@PathVariable Integer id) throws ModelNotFoundException{
		Profesor profesor = ProfesorService.retornarProfesor(id);
		return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
	}
	
	@ApiOperation(value = "guarda un profesor"
    		,notes = "Este servicio guarda un profesor mediante el envio de un cuerpo con datos correctos")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "CREATED. La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello", response = Profesor.class ),
	        @ApiResponse(code = 415, message = "UNSUPPORTED MEDIA TYPE. El formato multimedia de los datos solicitados no está soportado por el servidor"),
	        @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Valid @RequestBody Profesor profesor) throws  CedulaDuplicadaException {
		ProfesorService.guardar(profesor);
		return new ResponseEntity<Object>(profesor, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "editar un profesor"
    		,notes = "Este servicio edita un profesor mediante el envio de un id para obtener el recurso solicitado")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "CREATED. La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello", response = Profesor.class ),
	        @ApiResponse(code = 400, message = "BAD REQUEST. el servidor no pudo interpretar la solicitud dada una sintaxis inválida"),
	        @ApiResponse(code = 404, message = "NOT FOUND. recurso no encontrado"),
	        @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@RequestBody Profesor profesor) throws ModelNotFoundException, CedulaDuplicadaException {
		ProfesorService.editar(profesor);
		return new ResponseEntity<Object>(profesor, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "eliminar un profesor"
    		,notes = "Este servicio elimina un profesor mediante el envio de un id existente correspondiente al profesor solicitado")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "NO CONTENT. La respuesta no tiene ningún contenido"),
	        @ApiResponse(code = 400, message = "BAD REQUEST. el servidor no pudo interpretar la solicitud dada una sintaxis inválida", response = Profesor.class ),
	        @ApiResponse(code = 404, message = "NOT FOUND. recurso no encontrado"),
	        @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@DeleteMapping("/eliminar/{id}") 
	public ResponseEntity<Object> eliminar(@PathVariable int id) throws ModelNotFoundException {
		ProfesorService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
		

}
