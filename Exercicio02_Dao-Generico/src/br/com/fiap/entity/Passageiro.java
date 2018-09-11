package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PASSAGEIRO")
@SequenceGenerator(allocationSize=1, name="passageiro",sequenceName="SQ_T_PASSAGEIRO")
public class Passageiro {
	
	@Id
	@GeneratedValue(generator="passageiro",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_passageiro",nullable=false)
	private int codigo;
	
	@Column(name="nm_passageiro",nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="ds_genero")
	private String genero;

	
	//Construtor Cheio
	public Passageiro(String nome, Calendar dataNascimento, String genero) {
		super();
		setNome(nome);
		setDataNascimento(dataNascimento);
		setGenero(genero);
	}

	//Construtor Vazio
	public Passageiro() {
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
