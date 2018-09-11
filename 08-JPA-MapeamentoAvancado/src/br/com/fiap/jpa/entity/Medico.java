package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "T_MEDICO")
@SecondaryTable(name = "T_MEDICO_FINANCEIRO")
public class Medico {

	@Id
	@Column(name = "nr_crm")
	private long crm;
	@Column(name = "nm_medico", nullable = false, length = 100)
	private String nome;
	@Column(name = "vl_salario", table = "T_MEDICO_FINANCEIRO")
	private double salario;
	@Column(name = "dt_pagamento")
	private Calendar dataPagamento;

	public Medico(long crm, String nome, double salario, Calendar dataPagamento) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.salario = salario;
		this.setDataPagamento(dataPagamento);
	}

	public Calendar getDataPagemento() {
		return getDataPagamento();
	}

	public void setDataPagemento(Calendar dataPagemento) {
		this.setDataPagamento(dataPagamento);
	}

	public Medico() {
		super();
	}

	public Medico(long crm, String nome, double salario) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.salario = salario;
	}

	public long getCrm() {
		return crm;
	}

	public void setCrm(long crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
