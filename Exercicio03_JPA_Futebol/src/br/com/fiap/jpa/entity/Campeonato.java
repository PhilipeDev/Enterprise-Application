package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CAMPEONATO")
@SequenceGenerator(allocationSize=1,sequenceName="SEQ_T_CAMPEONATO",name="campeonato")
public class Campeonato {

	@Id
	@Column(name="cd_campeonato")
	@GeneratedValue(generator="campeonato", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_campeonato", length=100)
	private String nome;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinTable(name="T_TIME_CAMPEONATO",
				joinColumns=@JoinColumn(name="cd_campeonato"),
				inverseJoinColumns=@JoinColumn(name="cd_time"))
	List<Time> times = new ArrayList<>();

	
	
	//Construtor Vazio
	public Campeonato() {
		super();
	}

	//Construtor Cheio
	public Campeonato(String nome, List<Time> times) {
		super();
		setNome(nome);
		setTimes(times);
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

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
	
}
