package br.com.fiap.bean;

import java.util.Calendar;

public class ContaCorrente extends Conta{
	
	private TipoConta tipo;
	
	public void retirar(double valor) throws Exception {
		if(tipo == (TipoConta.COMUM) && (saldo-valor<0)) {
			throw new Exception("Saldo insuficiente");
		}else {
			saldo -= valor;
		}
	}

	//Construtor Cheio
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	//Construtor vazio
	public ContaCorrente() {
		super();
	}



	//Getter's and Setter's
	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	
	
}
