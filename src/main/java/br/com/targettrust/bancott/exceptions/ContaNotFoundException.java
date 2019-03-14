package br.com.targettrust.bancott.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContaNotFoundException extends RuntimeException {

	private String mensagem = "Conta não encontrada.";
	
	public ContaNotFoundException(String mensagem) {
		super(mensagem);
	}
	
}
