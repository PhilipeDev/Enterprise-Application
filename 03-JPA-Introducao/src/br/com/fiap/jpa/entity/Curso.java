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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CURSO")
@SequenceGenerator(name="curso", sequenceName="SEQ_T_CURSO", allocationSize=1)
public class Curso implements Serializable{

	
	@Id
	@Column(name="cd_curso")
	@GeneratedValue(generator="curso", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_curso", nullable=false, length=100)
	private String nome;
	
	@Column(name="nr_horas")
	private Integer horas;
	
	@Temporal(TemporalType.DATE) //Somente Data
	@Column(name="dt_lancamento")
	private Calendar dtLancamento;
	
	@Column(name="vl_enade")
	private double notaEnade;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private DescricaoCurso tipo;
	
	
	
	//Construtor Vazio
	public Curso() {
		super();
	}
	
	
	//Construtor Cheio
	public Curso(int codigo, String nome, Integer horas, Calendar dtLancamento, double notaEnade, DescricaoCurso tipo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.horas = horas;
		this.dtLancamento = dtLancamento;
		this.notaEnade = notaEnade;
		this.tipo = tipo;
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


	public Integer getHoras() {
		return horas;
	}


	public void setHoras(Integer horas) {
		this.horas = horas;
	}


	public Calendar getDtLancamento() {
		return dtLancamento;
	}


	public void setDtLancamento(Calendar dtLancamento) {
		this.dtLancamento = dtLancamento;
	}


	public double getNotaEnade() {
		return notaEnade;
	}


	public void setNotaEnade(double notaEnade) {
		this.notaEnade = notaEnade;
	}


	public DescricaoCurso getTipo() {
		return tipo;
	}


	public void setTipo(DescricaoCurso tipo) {
		this.tipo = tipo;
	}
	
	
	
}
