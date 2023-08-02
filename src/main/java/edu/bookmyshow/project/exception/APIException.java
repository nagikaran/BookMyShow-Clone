package edu.bookmyshow.project.exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException{
	private String message;
	private HttpStatus httpStatus;	
    private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public APIException(){
		super();
	}
	
	public APIException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	

}
