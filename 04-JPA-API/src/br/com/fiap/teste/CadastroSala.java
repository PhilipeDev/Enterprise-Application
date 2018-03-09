package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.beans.Sala;
import br.com.fiap.beans.Status;

public class CadastroSala {
	public static void main(String[] args) {
		
		//Fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Gerenciador de dados
		EntityManager em = fabrica.createEntityManager();
		
		Sala sala = new Sala(40, 7, "703", Status.INDISPONIVEL, new GregorianCalendar(2017, Calendar.MARCH, 2), null);
		
		//Cadastrar a sala
		em.persist(sala);
		
		
		//SEMPRE COME�AR E COMITAR AS TRANSA��ES, POIS H� MUDAN�A NA BASE DE DADOS.
		em.getTransaction().begin();
		//Commit - gravar as altera��es realizadas no banco de dados.
		em.getTransaction().commit();
		
		
		
		//Fechando o gerenciador de dados e a f�brica
		em.close();
		fabrica.close();
	}
}
