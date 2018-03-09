package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Teste {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(1, 201, 
				Calendar.getInstance(), 40, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(1, 202, 
				new GregorianCalendar(2010, Calendar.JANUARY, 2), 
					200, 1);
		
		List<Conta> lista = new ArrayList<>();
		lista.add(cp);
		lista.add(cc);
		
		for(Conta conta : lista) {
			System.out.println(conta.getSaldo());
			
			//Valida o tipo da instancia do objeto
			if(conta instanceof ContaCorrente) {
				ContaCorrente c = (ContaCorrente) conta;
				System.out.println(c.getTipo());
			}
		}
	}
}
