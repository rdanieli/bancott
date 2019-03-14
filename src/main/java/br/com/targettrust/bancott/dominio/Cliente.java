package br.com.targettrust.bancott.dominio;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	
	@Column(name="nome")
	@Size(min=2, message="O nome deve conter ao menos duas silabas")
	private String nome;

	@Column(name="endereco")
	@Size(min=2, message="O endereço deve conter ao menos duas silabas")
	private String endereco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	@Past
	private Calendar dataNascimento;
	
	@Column(name="email")
	@Email
	private String email;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
//	@OneToMany(mappedBy="conta")
//	private List<Conta> contas;
}
