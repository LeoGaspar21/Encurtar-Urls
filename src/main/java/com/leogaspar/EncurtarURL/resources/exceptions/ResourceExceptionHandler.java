package com.leogaspar.EncurtarURL.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.leogaspar.EncurtarURL.services.exceptions.UrlNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(UrlNotFoundException.class)
	public ResponseEntity<StandardError> urlNotFound(UrlNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(),
				"Não encontrado", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler()
	public ResponseEntity<StandardError> handleValidation(MethodArgumentNotValidException e,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(),
				"Erro de validação", request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

}
