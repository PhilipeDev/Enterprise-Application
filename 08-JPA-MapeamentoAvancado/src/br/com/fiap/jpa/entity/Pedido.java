package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PEDIDO")
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	private int codigo;
	
	@Column(name="nm_cliente")
	private String nome;
	
	@Column(name="dt_pedido")
	@Temporal(TemporalType.DATE)
	private Calendar dataPedido;

	
	
	//Construtor Vazio
	public Pedido() {
		super();
	}

	//Construtor Cheio
	public Pedido(int codigo, String nome, Calendar dataPedido) {
		super();
		setCodigo(codigo);
		setNome(nome);
		setDataPedido(dataPedido);
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

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
}
