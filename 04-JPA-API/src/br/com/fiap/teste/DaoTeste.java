package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.beans.Sala;
import br.com.fiap.beans.Status;
import br.com.fiap.dao.SalaDAO;
import br.com.fiap.dao.impl.SalaDAOImpl;

public class DaoTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		SalaDAO dao = new SalaDAOImpl(em);
		
		//Cadastrar
		Sala sala = new Sala(35, 7, "710", Status.MANUTENCAO, new GregorianCalendar(2017, Calendar.MARCH, 2), null);
		try {
			dao.cadastrar(sala);
			dao.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Buscar
		Sala salaBusca = dao.consultar(sala.getCodigo());
		System.out.println(salaBusca.getNome());
		
		//Remover
		try {
			dao.excluir(salaBusca.getCodigo());
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Atualizar
		salaBusca.setNome("Maker Lab");
		try {
			dao.atualizar(salaBusca);
			dao.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
	}
}
