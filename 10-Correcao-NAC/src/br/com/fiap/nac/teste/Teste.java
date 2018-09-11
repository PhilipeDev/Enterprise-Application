package br.com.fiap.nac.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.entity.Autor;
import br.com.fiap.jpa.entity.Editora;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.nac.dao.LivroDAO;
import br.com.fiap.nac.dao.impl.LivroDAOImpl;
import br.com.fiap.nac.exception.DBException;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		LivroDAO dao = new LivroDAOImpl(em);
		
		Livro livro = new Livro("123", "Livro teste", null);
		Editora editora = new Editora("Editora Teste");
		Autor autor = new Autor("Autor Teste",Calendar.getInstance());
		
		livro.setEditora(editora);
		
		List<Autor> autores = new ArrayList<>();
		autores.add(autor);
		livro.setAutores(autores);
		
		dao.cadastrar(livro);
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
