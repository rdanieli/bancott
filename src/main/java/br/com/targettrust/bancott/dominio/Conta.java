package br.com.targettrust.bancott.dominio;

import java.util.List;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="numero")
	private Long numero;
	
	@JoinColumn(name="fk_agencia_numero", nullable=false, 
			insertable=true, 
			updatable=true, 
			unique=false )
	@ManyToOne
	private Agencia agencia;
	
	@JoinColumn(name="fk_cliente_id", nullable=false, 
			insertable=true, 
			updatable=true, 
			unique=false )
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy="contaOrigem")
	private List<Transacao> transacoesContaOrigem;
	
	@OneToMany(mappedBy="contaDestino")
	private List<Transacao> transacoesContaDestino;
}
