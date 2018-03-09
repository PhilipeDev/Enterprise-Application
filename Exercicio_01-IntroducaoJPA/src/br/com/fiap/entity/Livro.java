package br.com.fiap.entity;

import java.io.Serializable;
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
@Table(name="T_LIVRO")
@SequenceGenerator(name="livro", sequenceName="SEQ_T_LIVRO", allocationSize=1)
public class Livro implements Serializable{
	
	@Id
	@Column(name="nr_isbn")
	private int codigo;
	
	@Column(name="nm_titulo", nullable=false, length=200)
	private String titulo;
	
	@Column(name="vl_livro")
	private float valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dataLancamento;
	
	@Column(name="ds_capa")
	private byte[] capa;

	
	
	//Getter's and Setter's
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

	//Construtor Vazio
	public Livro() {
		super();
	}

	//Construtor Cheio
	public Livro(int codigo, String titulo, float valor, Calendar dataLancamento, byte[] capa) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}
	

	
}
