package br.com.targettrust.bancott.dominio;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Todos os detalhes sobre a agencia")
public class AgenciaDTO {

	@ApiModelProperty(notes="Nome da agencia")
	private String nome;

	@ApiModelProperty(notes="Numero da agencia")
	private Long numero;
	
	public AgenciaDTO() {
	}

	public AgenciaDTO(String nome, Long numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
	
}
