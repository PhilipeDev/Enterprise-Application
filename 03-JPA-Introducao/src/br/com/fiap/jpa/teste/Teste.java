package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.StatusAluno;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
				
		EntityManager em = fabrica.createEntityManager();
		

		Aluno aluno = new Aluno("Felipe", 
				new GregorianCalendar(2000, Calendar.JANUARY, 12), StatusAluno.CURSANDO, "felipe@fiap.com.br", null, 1, 18, null);
		
		
		
		//Cadastrar o aluno
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
