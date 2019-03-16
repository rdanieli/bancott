package br.com.targettrust.bancott.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	class ExceptionCustomizada {
		private String mensagem;
		private Date date;
		
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}	
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
				
		ExceptionCustomizada customizada = new ExceptionCustomizada();
		
		StringBuilder sb = new StringBuilder();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			sb.append(error.getDefaultMessage());
			sb.append("\n");
		}
		
		customizada.setMensagem(sb.toString());
		customizada.setDate(new Date());
		
		return new ResponseEntity<Object>(customizada, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionCustomizada> handleAllExceptions(Exception exception,
			WebRequest webRequest) {
		
		ExceptionCustomizada customizada = new ExceptionCustomizada();
		customizada.setMensagem(exception.getMessage());
		customizada.setDate(new Date());
		
		return new ResponseEntity<ExceptionCustomizada>(customizada, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ContaNotFoundException.class)
	public final ResponseEntity<ExceptionCustomizada> handleContaNotFoundException(Exception exception,
			WebRequest webRequest) {
		ExceptionCustomizada customizada = new ExceptionCustomizada();
		customizada.setMensagem(exception.getMessage());
		customizada.setDate(new Date());
		
		return new ResponseEntity<ExceptionCustomizada>(customizada, HttpStatus.NOT_FOUND);
	}
	
	
}
