package br.com.fiap.jpa.entity;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_ALUNO")
@SequenceGenerator(name="aluno", sequenceName="SEQ_T_ALUNO", allocationSize=1)
public class Aluno implements Serializable {
	
	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(generator="aluno", strategy=GenerationType.SEQUENCE)
	private int rm;
	
	@Column(name="nm_aluno", nullable=false, length=100)
	private String nome;
	
	@Temporal(TemporalType.DATE) //Somente a data
	@Column(name="dt_nascimento")
	private Calendar dtNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="st_aluno", nullable=false)
	private StatusAluno status;
	
	@Column(name="ds_email", nullable=false, length=50)
	private String email;
	
	@Column(name="vl_media")
	private Float media;
	
	@Column(name="nr_semestre", nullable=false)
	private int semestre;
	
	@Transient
	private int idade;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	//Construtor Vazio
	public Aluno() {
		super();
	}

	//Construtor Cheio
	public Aluno(String nome, Calendar dtNascimento, StatusAluno status, String email, Float media,
			int semestre, int idade, byte[] foto) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.status = status;
		this.email = email;
		this.media = media;
		this.semestre = semestre;
		this.idade = idade;
		this.foto = foto;
	}

	//Getter's and Setter's
	
	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public StatusAluno getStatus() {
		return status;
	}

	public void setStatus(StatusAluno status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getMedia() {
		return media;
	}

	public void setMedia(Float media) {
		this.media = media;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	

}
