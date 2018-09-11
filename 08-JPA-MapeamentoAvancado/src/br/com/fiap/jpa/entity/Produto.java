package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUTO")
public class Produto {

	@Id
	@Column(name="cd_produto")
	private int codigo;
	@Column(name="nm_produto")
	private String nome;
	@Column(name="ds_produto")
	private String descricao;

	
	
	//Construtor Cheio
	public Produto(int codigo, String nome, String descricao) {
		super();
		setCodigo(codigo);
		setNome(nome);
		setDescricao(descricao);
	}

	
	//Construtor Vazio
	public Produto() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
