package br.com.targettrust.bancott.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contas")
public class Conta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="numero")
	private Long numero;
	
	@JoinColumn(name="fk_agencia_numero", nullable=false, 
			insertable=true, 
			updatable=true, 
			unique=false )
	@ManyToOne(cascade=CascadeType.ALL)
	private Agencia agencia;
	
	@JoinColumn(name="fk_cliente_id", nullable=false, 
			insertable=true, 
			updatable=true, 
			unique=false )
	@ManyToOne(cascade=CascadeType.ALL)
	private Cliente cliente;

	@Column(name="saldo")
	private Double saldo;
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
//	
//	@OneToMany(mappedBy="contaOrigem")
//	private List<Transacao> transacoesContaOrigem;
//	
//	@OneToMany(mappedBy="contaDestino")
//	private List<Transacao> transacoesContaDestino;
}
