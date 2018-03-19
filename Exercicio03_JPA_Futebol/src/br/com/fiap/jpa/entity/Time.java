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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TIME")
@SequenceGenerator(allocationSize=1, name="time", sequenceName="SEQ_T_TIME")
public class Time {
	
	@Id
	@Column(name="cd_time")
	@GeneratedValue(generator="time", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_time", length=50, nullable=false)
	private String nome;
	
	@OneToOne
	@JoinColumn(name="fk_cd_tecnico")
	private Tecnico tecnico;

	@OneToMany(mappedBy="time", cascade=CascadeType.PERSIST)
	List<Jogador> jogadores = new ArrayList<>();
	
	
	//Método para adicionar jogadores a lista
	//Utilizado apenas para oneToMany
	public void adicionarJogadores(Jogador jogador) {
		jogadores.add(jogador);
		jogador.setTime(this);
	}
	
	//MappedBy sempre se refere ao atributo da outra classe onde foi definido.	
	@ManyToMany(mappedBy="times", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Campeonato> campeonatos = new ArrayList<>();
	
	
	//Construtor Vazio
	public Time() {
		super();
	}

	//Construtor Cheio
	public Time(String nome, Tecnico tecnico) {
		super();
		setNome(nome);
		setTecnico(tecnico);
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

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	
}
