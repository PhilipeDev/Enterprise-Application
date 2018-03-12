package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GrupoAmDAO;
import br.com.fiap.jpa.dao.ProjetoAmDAO;
import br.com.fiap.jpa.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.jpa.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.jpa.entity.GrupoAM;
import br.com.fiap.jpa.entity.ProjetoAM;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar o projeto e o grupo
		GrupoAmDAO gDAO = new GrupoAmDAOImpl(em);
		ProjetoAmDAO pDAO = new ProjetoAmDAOImpl(em);
		
		ProjetoAM projeto = new ProjetoAM(Calendar.getInstance(), 
				"QuatiFactory", new GregorianCalendar(2016, Calendar.NOVEMBER, 10));
		
		GrupoAM grupo = new GrupoAM("Quati Sistemas", 0, projeto);
		
		
		
		try {
			//pDAO.cadastrar(projeto);
			gDAO.cadastrar(grupo);
			gDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao cadastrar o grupo");
		}
		
		em.close();
		fabrica.close();
	}
}
