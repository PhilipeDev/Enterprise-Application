package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GrupoAmDAO;
import br.com.fiap.jpa.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.jpa.entity.GrupoAM;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;


public class BuscaTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		
		//Buscar o grupo
		GrupoAM grupo = dao.consultar(1);
		System.out.println(grupo.getNome());
		System.out.println(grupo.getProjeto().getNome());
		
		
		em.close();
		fabrica.close();
	}
	
}
