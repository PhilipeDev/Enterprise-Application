package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.beans.Sala;
import br.com.fiap.beans.Status;

public class AtualizaTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma sala no banco de dados
				//tabela, chave primária
		Sala sala = new Sala(70, 7, "701", Status.DISPONIVEL, new GregorianCalendar(2015, Calendar.JANUARY, 1), null);
		
		sala.setCodigo(1);
		
		em.merge(sala);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechando as conexões
		em.close();
		fabrica.close();
	}
}
