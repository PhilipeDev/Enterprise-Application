package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EDITORA")
@SequenceGenerator(name="editora", sequenceName="SQL_T_EDITORA", allocationSize=1)

public class Editora implements Serializable{
	
	@Id
	@Column(name="cd_editora")
	@GeneratedValue(generator="editora", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nr_cnpj", nullable=false)
	private String cnpj;
	
	@Column(name="nm_editora", nullable=false, length=100)
	private String nome;
	
	@Column(name="ds_endereco", length=100)
	private String endereco;

	
	
	//Construtor Vazio
	public Editora() {
		super();
	}

	//Construtor Cheio
	public Editora(int codigo, String cnpj, String nome, String endereco) {
		super();
		this.codigo = codigo;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	//Getter's and Setter's
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	
}
