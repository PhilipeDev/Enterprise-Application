package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PROJETO")
@SequenceGenerator(name="projeto", sequenceName="SEQ_T_PROJETO", allocationSize=1)
public class ProjetoAM {
	
	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(generator="projeto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_projeto", length=100, nullable=false)
	private String nome;
	@Column(name="dt_inicio", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Calendar dataFim;
	
	@OneToOne(mappedBy="projeto")
	private GrupoAM grupo;
	
	
	//Construtor Cheio
	public ProjetoAM(Calendar dataInicio,String nome, Calendar dataFim) {
		setDataInicio(dataInicio);
		setNome(nome);
		setDataFim(dataFim);
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

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
