package br.com.targettrust.bancott.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	
//	@OneToMany(mappedBy="conta")
//	private List<Conta> contas;
}
