package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.beans.Sala;

public class DeletaTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Sala sala = em.find(Sala.class, 2);
		em.remove(sala);
		
		//SEMPRE COMEÇAR E COMITAR AS TRANSAÇÕES, POIS HÁ MUDANÇA NA BASE DE DADOS.
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
