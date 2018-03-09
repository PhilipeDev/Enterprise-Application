package br.com.fiap.beans;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Tabela;


public class Aluno {
	@Tabela(nome="T_ALUNO")
	
	@Coluna(nome="nm_aluno")
	private String nome;
	@Coluna(nome="nr_idade")
	private int idade;
	@Coluna(nome="nr_codigo")
	private int codigo;
	
	
	//Construtor Cheio	
	public Aluno(String nome, int idade, int codigo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.codigo = codigo;
	}


	//Construtor Vazio
	public Aluno() {
		super();
	}

	
	//Getter's and Setter's
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
