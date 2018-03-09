package br.com.fiap.beans;

import br.com.fiap.annotation.Coluna;

public class Produto {
	
	@Coluna(nome="cd_produto")
	private int codigo;
	
	@Coluna(nome="nm_produto")
	private String nome;
	

	
	//Construtor cheio
	public Produto(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	//Construtor Vazio
	public Produto() {
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
	
	
}
