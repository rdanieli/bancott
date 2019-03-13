package br.com.targettrust.bancott.dominio;

public class AgenciaDTO {

	private String nome;
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
