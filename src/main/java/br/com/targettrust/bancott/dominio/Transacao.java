package br.com.targettrust.bancott.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transacoes")
public class Transacao {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name="fk_conta_numero_origem", nullable=false, 
			insertable=true, 
			updatable=true, 
			unique=false )
	@ManyToOne
	private Conta contaOrigem;
	
	@JoinColumn(name="fk_conta_numero_destino", nullable=false, 
			insertable=true, 
			updatable=true, 
			unique=false )
	@ManyToOne
	private Conta contaDestino;	
}
