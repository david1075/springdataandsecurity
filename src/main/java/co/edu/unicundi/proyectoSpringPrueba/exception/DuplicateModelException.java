package co.edu.unicundi.proyectoSpringPrueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class DuplicateModelException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public DuplicateModelException(String message) {
		super(message);
		
	}

	

	
}
