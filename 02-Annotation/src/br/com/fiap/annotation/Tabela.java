package br.com.fiap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Mantem a anotação até a execução
@Retention(RetentionPolicy.RUNTIME)
//Define qual a anotação é para atributos
@Target(ElementType.FIELD)
public @interface Tabela {
	String nome();
}
