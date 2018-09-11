package br.com.fiap.bo.impl;

import java.util.Calendar;
import javax.ejb.Stateless;
import br.com.fiap.bo.ClienteBO;

@Stateless
public class ClienteBOImpl implements ClienteBO{

	@Override
	public int calcularIdade(Calendar idade) {
		Calendar atual = Calendar.getInstance();
		int anoIdade = idade.get(Calendar.YEAR);
		int anoAtual = atual.get(Calendar.YEAR);
		
		int mesIdade = idade.get(Calendar.MONTH);
		int mesAtual = atual.get(Calendar.MONTH);
		
		int diaIdade = idade.get(Calendar.DAY_OF_MONTH);
		int diaAtual = idade.get(Calendar.DAY_OF_MONTH);
		
		int ano = 0; 
		
		if(mesAtual < mesIdade) {//Não fez aniversário
			ano = anoAtual - anoIdade -1;
		}else if(mesAtual > mesIdade){
			ano = anoAtual - anoIdade;
		}else {
			if(diaAtual < diaIdade) {
				ano = anoAtual - anoIdade -1;
			}else {
				ano = anoAtual - anoIdade;
			}
		}
		return ano;
	}
	
}
