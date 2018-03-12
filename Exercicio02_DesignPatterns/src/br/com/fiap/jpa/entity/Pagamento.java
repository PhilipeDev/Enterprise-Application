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
@Table(name="T_PAGAMENTO")
@SequenceGenerator(name="pagamento", sequenceName="SEQ_T_PAGAMENTO" ,allocationSize=1)
public class Pagamento {
	
	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(generator="pagamento", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_pagamento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;
	
	@Column(name="vl_pagamento", nullable=false)
	private float valor;
	
	@Column(name="ds_forma_pagamento", nullable=false)
	private FormaPagamento formaPagamento;

	//Construtor Cheio
	public Pagamento(int codigo, Calendar dataPagamento, float valor, FormaPagamento formaPagamento) {
		setCodigo(codigo);
		setDataPagamento(dataPagamento);
		setValor(valor);
		setFormaPagamento(formaPagamento);
	}

	//Construtor Vazio
	public Pagamento() {
	}
	
	
	//Getter's and Setter's
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	
}
