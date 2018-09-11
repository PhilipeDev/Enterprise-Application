package br.com.fiap.nac.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.nac.dao.LivroDAO;
import br.com.fiap.nac.dao.impl.LivroDAOImpl;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class TesteBusca {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		LivroDAO dao = new LivroDAOImpl(em);
		
		//Teste 1
		List<Livro> lista = dao.buscarPorTitulo("e");
		for (Livro livro : lista) {
			System.out.println(livro.getTitulo());
		}
		
		//Teste 2
		System.out.println("Livros: " + dao.contarPorEditora(1));
		
		//Teste 3
		lista = dao.buscarPorNomeEditora("e");
		for (Livro livro : lista) {
			System.out.println(livro.getTitulo());
		}
		
		em.close();
		fabrica.close();
	}
	
}
