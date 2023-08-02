package edu.bookmyshow.project.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.bookmyshow.project.dto.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(APIException.class)
	public ResponseEntity<ApiResponse> apiExceptionHandler(APIException e){
		return ResponseEntity.status(e.getHttpStatus()).body(new ApiResponse(e.getMessage(),e.getHttpStatus(),false));
	}
	

}
