package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.JOINED)
//Configuração da estratégia SINGLE_TABLE
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="DS_TIPO")
//@DiscriminatorValue("P")

@Entity
@Table(name="T_PESSOA")
@SequenceGenerator(allocationSize=1, sequenceName="SQ_T_PESSOA",name="pessoa")
public class Pessoa {
	
	
	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(generator="pessoa",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pessoa", nullable=false)
	private String nome;
	
	@Column(name="ds_email")
	private String email;

	//Construtor Cheio
	public Pessoa(String nome, String email) {
		super();
		setNome(nome);
		setEmail(email);
	}

	//Construtor Vazio
	public Pessoa() {
		super();
	}


	//Getter's and Setter's
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
