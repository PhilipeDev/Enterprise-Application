package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Tabela;
import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Produto;

public class AnnotationTeste {
	public static void main(String[] args) {
		Produto produto = new Produto(1,"Churros");
		
		//API de Reflection para recuperar a estrutura da classe
		String nome = produto.getClass().getName();	
		System.out.println(nome);
		
		//Recuperar os métodos
		Method[] metodos = produto.getClass().getDeclaredMethods();
		for(Method method : metodos) {
			System.out.println(method.getName());
		}
		
		//Recuperar os atributos
		Field[] atributos = produto.getClass().getDeclaredFields();
		
		for(Field field : atributos) {
			System.out.println(field.getName());
			//Recuperar a anotação
			Coluna anotacao = field.getAnnotation(Coluna.class);
			System.out.println(anotacao.nome());
		}
		
		
		
		//public static String gerarSql(Aluno aluno) {
	
			//Tabela nomeTabela = produto.getClass().getAnnotation(Tabela.class);
			
			//return "CREATE TABLE" + nomeTabela.nome();
		//}
	}
}
