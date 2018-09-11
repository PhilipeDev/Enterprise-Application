package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


//@DiscriminatorValue("PJ")
@Entity
@Table(name="T_PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{
	
	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Column(name="dt_abertura")
	private Calendar dataAbertura;

	
	//Construtor Vazio
	public PessoaJuridica() {
		super();
	}

	//Construtor Cheio
	public PessoaJuridica(String nome, String email, String cnpj, Calendar dataAbertura) {
		super(nome, email);
		setCnpj(cnpj);
		setDataAbertura(dataAbertura);
	}

	//Getter's and Setter's
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
}
