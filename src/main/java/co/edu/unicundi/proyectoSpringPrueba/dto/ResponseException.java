package co.edu.unicundi.proyectoSpringPrueba.dto;

import java.time.LocalDateTime;

public class ResponseException {

	//private localDateTime timestamp;
	
	private String timestamp;
	
	private int status;
	
	private String error;
	
	private String message;
	
	private String path;

	public ResponseException(int status, String error, String message, String path) {
		super();
		this.timestamp = LocalDateTime.now().toString();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	

}