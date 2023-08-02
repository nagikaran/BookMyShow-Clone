package edu.bookmyshow.project.dto;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	private String message;
	private HttpStatus status;
	private Boolean success;
	
	public ApiResponse(String message, HttpStatus status, Boolean success) {
		super();
		this.message = message;
		this.status = status;
		this.success = success;
	}
	public ApiResponse() {
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
	
	


}
