package br.com.gestao.contas.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GestaoContasControllerAdvice {
	
	@ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<MensagemErro> handleResponseStatusExcpetion(ResponseStatusException ex, WebRequest request) {
		return ResponseEntity.status(ex.getStatusCode()).body(new MensagemErro(ex.getReason()));
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<MensagemErro> handleExcpetion(Exception exception, WebRequest request){
		return ResponseEntity.internalServerError().body(new MensagemErro(exception.getMessage()));
	}

}