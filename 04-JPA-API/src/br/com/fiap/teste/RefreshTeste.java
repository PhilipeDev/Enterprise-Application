package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.beans.Sala;

public class RefreshTeste {
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma sala no bnaco de dados
		Sala sala  = em.find(Sala.class, 1);
		//Exibir o nome
		System.out.println("Nome:" + sala.getNome());
		
		//Atualizar o nome da sala no java
		sala.setNome("706");
		//Exibir o nome
		System.out.println("Nome:"+ sala.getNome());
		//Fazer o refresh
		em.refresh(sala);
		//Exibir o nome
		System.out.println(sala.getNome());
		
		
		em.close();
		fabrica.close();
		
	}
}
