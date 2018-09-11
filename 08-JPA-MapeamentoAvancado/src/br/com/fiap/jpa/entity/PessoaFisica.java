package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



//@DiscriminatorValue("PF")
@Entity
@Table(name="T_PESSOA_FISICA")
public class PessoaFisica extends Pessoa{

	@Column(name="nr_cpf")
	private String cpf;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	
	//Construtor Cheio
	public PessoaFisica(String nome, String email, String cpf, Calendar dataNascimento) {
		super(nome, email);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
	}

	
	//Construtor Vazio
	public PessoaFisica() {
		super();
	}



	//Getter's and Setter's
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
