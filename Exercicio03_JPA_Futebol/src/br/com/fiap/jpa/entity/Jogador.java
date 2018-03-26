package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_JOGADOR")
@SequenceGenerator(allocationSize=1, name="jogador",sequenceName="SEQ_T_JOGADOR")
public class Jogador {

	@Id
	@Column(name="cd_jogador")
	@GeneratedValue(generator="jogador", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_jogador", nullable=false, length=100)
	private String nome;
	
	@Column(name="ds_posicao")
	private Posicao posicao;
	
	//ManyToOne pois temos varios jogadores para um time.
	@ManyToOne
	//JoinColumn ele é opcional, serve para renomear a coluna
	@JoinColumn(name="fk_cd_time")
	private Time time;

	
	//Construtor Vazio
	public Jogador() {
		super();
	}

	//Construtor Cheio
	public Jogador(String nome, Posicao posicao, Time time) {
		super();
		setNome(nome);
		setPosicao(posicao);
		setTime(time);
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

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
