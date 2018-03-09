package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_CLIENTE")
public class Cliente {
	
	@Id
	@Column(name="ds_email", length=50)
	private String email;
	
	@Column(name="nm_cliente", nullable=false, length=25)
	private String nome;
	
	@Column(name="vl_total", nullable=false)
	private float valorTotal;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoCliente tipo;

	//Construtor Cheio
	public Cliente(String email, String nome, float valorTotal, TipoCliente tipo) {
		super();
		setEmail(email);
		setNome(nome);
		setValorTotal(valorTotal);
		setTipo(tipo);
	}

	
	//Construtor Vazio
	public Cliente() {
		super();
	}



	//Getter's and Setter's
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
