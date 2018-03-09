package br.com.fiap.teste;

import br.com.fiap.bean.TipoConta;

public class TesteEnum {

	public static void main(String[] args) {
		TipoConta tipo = TipoConta.COMUM;
		
		if (tipo == TipoConta.COMUM) {
			System.out.println(tipo);
		}
	}
	
}
