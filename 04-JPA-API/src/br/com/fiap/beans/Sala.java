package br.com.fiap.beans;
import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_SALA")
@SequenceGenerator(name="sala", sequenceName="SQ_T_SALA", allocationSize=1)
public class Sala implements Serializable{

	@Id
	@Column(name="cd_sala")
	@GeneratedValue(generator="sala", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="vl_capacidade", nullable=false)
	private int capacidade;
	
	@Column(name="nr_andar", nullable=false)
	private int andar;
	
	@Column(name="nm_sala", length=50)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="st_sala", nullable=false)
	private Status status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inauguracao")
	private Calendar inauguracao;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	
	
	//Construtor Cheio
	public Sala(int capacidade, int andar, String nome, Status status, Calendar inauguracao, byte[] foto) {
		super();
		this.capacidade = capacidade;
		this.andar = andar;
		this.nome = nome;
		this.status = status;
		this.inauguracao = inauguracao;
		this.foto = foto;
	}
	
	
	
	//Construtor Vazio
	public Sala() {
		super();
	}


	@PrePersist
	public void antesCadastrar() {
		System.out.println("Sala será cadastrada");
	}
	
	//Getter's and Setter's
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getInauguracao() {
		return inauguracao;
	}

	public void setInauguracao(Calendar inauguracao) {
		this.inauguracao = inauguracao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}
