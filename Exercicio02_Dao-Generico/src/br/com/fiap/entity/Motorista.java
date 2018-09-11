package br.com.fiap.entity;

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
@Table(name="T_MOTORISTA")
@SequenceGenerator(allocationSize=1, name="motorista", sequenceName="SQ_T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name="nr_carteira", nullable=false)
	@GeneratedValue(generator="motorista",strategy=GenerationType.SEQUENCE)
	private int numero;
	
	@Column(name="nm_motorista",length=150,nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="fl_carteira")
	@Enumerated(EnumType.STRING)
	private byte[] foto;
	
	@Column(name="ds_genero")
	private String genero;

	
	//Construtor Cheio
	public Motorista(String nome, Calendar dataNascimento, byte[] foto, String genero) {
		super();
		setNome(nome);
		setDataNascimento(dataNascimento);
		setFoto(foto);
		setGenero(genero);
	}

	//Construtor Vazio
	public Motorista() {
		super();
	}


	//Getter's and Setter's
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
