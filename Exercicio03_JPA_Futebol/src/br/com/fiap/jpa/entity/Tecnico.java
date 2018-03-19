package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TECNICO")
@SequenceGenerator(allocationSize=1, name="tecnico", sequenceName="SEQ_T_TECNICO")
public class Tecnico {
	
	@Id
	@Column(name="cd_tecnico")
	@GeneratedValue(generator="tecnico", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_tecnico")
	private String nome;
	
	
	//Construtor Vazio
	public Tecnico() {
		super();
	}

	//Construtor Cheio
	public Tecnico(String nome) {
		super();
		setNome(nome);
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
