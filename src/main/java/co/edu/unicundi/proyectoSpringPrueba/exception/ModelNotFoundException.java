package co.edu.unicundi.proyectoSpringPrueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	//generar constructor donde se recibe la exception (String)
	public ModelNotFoundException(String message) {
		super(message);
		
	}

	
	
}
