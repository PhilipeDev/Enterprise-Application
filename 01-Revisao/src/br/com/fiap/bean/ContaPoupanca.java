package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento , Serializable {

	private float taxa;
	
	public static final float RENDIMENTO = 0.05f;
	
	public double calculaRetornoInvestimento() {
		
		return getSaldo()*RENDIMENTO;
	}

	
	
	public void retirar(double valor) throws Exception {
		
		if(getSaldo() >= valor + getTaxa()) {
			//valor = valor + getTaxa();
			saldo = saldo - valor - taxa;
		}else {
			throw new Exception("Saldo Insuficiente");
		}
	}
	
	
	
	//Construtor Cheio
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}
	
	
	//Construtor Vazio
	public ContaPoupanca() {
		super();
	}

	//Getter's and Setter's
	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}