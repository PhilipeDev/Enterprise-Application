package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ALUNO")
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	private String rm;
	
	@Column(name="nm_aluno", length=100, nullable=false)
	private String nome;

	//Unidimensional
	//ManyToOne pois temos varios alunos para um grupo.
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_cd_grupo")
	private GrupoAM grupo;
	
	
	//Construtor Cheio
	public Aluno(String rm, String nome, GrupoAM grupo) {
		super();
		setRm(rm);
		setNome(nome);
		setGrupo(grupo);
	}

	//Construtor Vazio
	public Aluno() {
		super();
	}


	//Getter's and Setter's
	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public GrupoAM getGrupo() {
		return grupo;
	}


	public void setGrupo(GrupoAM grupo) {
		this.grupo = grupo;
	}
	
	
	
	
}
