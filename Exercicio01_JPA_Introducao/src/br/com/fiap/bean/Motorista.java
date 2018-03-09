package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
public class Motorista implements Serializable{
	
	@Id
	@Column(name="nr_carteira", nullable=false)
	private int carteira;
	
	@Column(name="nm_motorista", nullable=false, length=150)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] foto;
	
	@Column(name="ds_genero")
	private Genero genero;

	
	
	//Construtor Cheio
	public Motorista(int carteira, String nome, Calendar dataNascimento, byte[] foto, Genero genero) {
		super();
		setCarteira(carteira);
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
	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
