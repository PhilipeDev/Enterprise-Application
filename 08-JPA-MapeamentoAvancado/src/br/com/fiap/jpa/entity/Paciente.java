package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "paciente", sequenceName = "SQ_T_PACIENTE", allocationSize = 1)
@Table(name = "T_PACIENTE")
public class Paciente {

	@Id
	@GeneratedValue(generator = "paciente", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_paciente", nullable = false)
	private String nome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	
	
	public Paciente() {
		super();
	}

	public Paciente(int codigo, String nome, Calendar dataNascimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
