package com.realestatemanager.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {

	public static final String NO_DATA_FOUND_ERROR="Data not Found for the request information";
	public static final String Error_500="Error 500 : An unexpected error happened on the server, please try again";
	
	 private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
	 
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "method not supported";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));	
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error = "Request Parameter type mismatch";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));	
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));	}

	
	@ExceptionHandler(NoDataFoundException.class)
	protected ResponseEntity<Object> noDataFound(final NoDataFoundException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError error=new ApiError(HttpStatus.NOT_FOUND);
		error.setDebugMessage(ex.getMessage());
		
	       return buildResponseEntity(error);	
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> allException(final Exception ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError error=new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
		error.setDebugMessage(ex.getMessage());
		
	       return buildResponseEntity(error);	
	}

}
