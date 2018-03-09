package br.com.fiap.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class TesteData {

	public static void main(String[] args) {
		//Trabalhar com data
		Calendar data = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		//Exibe a data formatada
		System.out.println(format.format(data.getTime()));
		
		String formatura = "10/12/2018";
		try {
			//Transformar a string em uma data
			System.out.println(format.parse(formatura));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Instanciar uma data especifica
		Calendar ferias = 
				new GregorianCalendar(2018, Calendar.DECEMBER, 2);
		//Imprimir a data de ferias
		System.out.println(format.format(ferias.getTime()));
		
	}
	
}








