package co.edu.unicundi.proyectoSpringPrueba.exception;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import co.edu.unicundi.proyectoSpringPrueba.dto.ResponseException;

//permite declarar métodos relacionados con el manejo de excepciones que serán compartidos entre múltiples controladores
@ControllerAdvice
@RestController
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

	private String mensaje;
	
	@ExceptionHandler(CedulaDuplicadaException.class)
	public ResponseEntity<ResponseException> filtroCedulaDuplicateException(CedulaDuplicadaException ex, WebRequest request){
		ex.printStackTrace();
		ResponseException exp = new ResponseException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), "Por Averiguar");
		return new ResponseEntity<ResponseException>(exp, HttpStatus.BAD_REQUEST); 
	}
	
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ResponseException> filtroLoginException(AccessDeniedException ex, WebRequest request){
		ex.printStackTrace();
		ResponseException exp = new ResponseException(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.toString(), ex.getMessage(), "Por Averiguar");
		return new ResponseEntity<ResponseException>(exp, HttpStatus.UNAUTHORIZED); 
	}
	
	@ExceptionHandler(ModelNotFoundException.class)
	public ResponseEntity<ResponseException> filtroModelNotFoundException(ModelNotFoundException ex, WebRequest request){
		ex.printStackTrace();
		ResponseException exp = new ResponseException(404, "NOT FOUND", ex.getMessage(), "Por Averiguar");
		return new ResponseEntity<ResponseException>(exp, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(ElementNecesaryException.class)
	public ResponseEntity<ResponseException> filtroElementNecesaryException(ElementNecesaryException ex, WebRequest request){
		ex.printStackTrace();
		ResponseException exp = new ResponseException(400, "BAD REQUEST", ex.getMessage(), "Sintaxis Invalida");
		return new ResponseEntity<ResponseException>(exp, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(DuplicateModelException.class)
	public ResponseEntity<ResponseException> filtroElementNecesaryException(DuplicateModelException ex, WebRequest request){
		ex.printStackTrace();
		ResponseException exp = new ResponseException(415, "UNSUPPORTED MEDIA TYPE", ex.getMessage(), "datos solicitados no soportados");
		return new ResponseEntity<ResponseException>(exp, HttpStatus.UNSUPPORTED_MEDIA_TYPE); 
	}
	
	
	/////////////////       sobreescribir los metodos que vienen en la clase 		///////////////////
	//json a text
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
		org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseException er = new ResponseException(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<Object>(er, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	// cuando falla la validación de un argumento anotado con @valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ex.getBindingResult().getFieldErrors().forEach(listaerror->{
			mensaje = listaerror.getDefaultMessage();
			System.out.println(listaerror.getRejectedValue() + " " + listaerror.getField() + " " + listaerror.getDefaultMessage());
		});
		ResponseException er = new ResponseException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), mensaje, request.getDescription(false));	
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
	
	// solicitud metodo post en un metodo get y viceversa
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseException er = new ResponseException(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.toString(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<Object>(er, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	// error de construccion en un JSON
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseException er = new ResponseException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
	
	// not found 
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseException er = new ResponseException(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<Object>(er, HttpStatus.NOT_FOUND);
	}
	
	
	
}
