package br.com.targettrust.bancott.dominio;

public class ContaDTO {

	private String numeroConta;
	private String numeroAgencia;
	private String nomeCliente;
	
	private Double saldo;

	public ContaDTO() {
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public ContaDTO(String numeroConta, String numeroAgencia, String nomeCliente, Double saldo) {
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
	}
	
	
	
}
