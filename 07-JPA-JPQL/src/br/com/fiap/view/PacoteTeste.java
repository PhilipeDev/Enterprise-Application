package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		
		//Busca por transporte
		Transporte transporte = transporteDao.pesquisar(1);
		List<Pacote> lista = pacoteDao.buscarPorTransporte(transporte);
		
		System.out.println("|----------------------|");
		System.out.println("Todos os pacotes");
		for (Pacote pacote : lista) {
			System.out.println(pacote.getDescricao());
			System.out.println(pacote.getPreco());
		}
		
		
		//Teste BuscarPorData
		System.out.println("|----------------------|");
		System.out.println("BUSCANDO PACOTES PELA DATA DE SAIDA");
		List<Pacote> listaPacotesPorData = pacoteDao.buscarPorData(new GregorianCalendar(2018, Calendar.JANUARY, 20), 
				new GregorianCalendar(2018, Calendar.AUGUST, 24));
		for (Pacote pacote : listaPacotesPorData) {
			System.out.println("Descrição do pacote: " + pacote.getDescricao());
			System.out.println("Data de saida do pacote: " + pacote.getDataSaida().getTime());
		}
		
		//Selecionar a média dos preços dos pacotes
		System.out.println("|----------------------|");
		System.out.println("Média dos Pacotes");
		double resultado = pacoteDao.mediaPacotes();
		System.out.println("Resultado da média: " +resultado);
		

		//Teste do select com NamedQuery
		System.out.println("|----------------------|");
		System.out.println("Busca por Data com Named Query");
		lista = pacoteDao.buscarPorData(new GregorianCalendar(2017, Calendar.SEPTEMBER, 23));
		for (Pacote pacote : lista) {
			System.out.println("Descrição: "+pacote.getDescricao());
		}
		
		//Teste da Query Nativa
		System.out.println("|----------------------|");
		System.out.println("Busca por Descrição com Native Query");
		lista = pacoteDao.buscarPorDescricao("a");
		for (Pacote pacote : lista) {
			System.out.println(pacote.getDescricao());
		}
		
		em.close();
		fabrica.close();
	}
	
}
