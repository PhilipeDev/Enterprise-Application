package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerancaTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		
		
		//Cadastrar uma pessoa, pessoa fisica e pessoa juridica.
		Pessoa p = new Pessoa("Thiago", "thiago@fiap.com.br");
		Pessoa pf = new PessoaFisica("Felipe", 
				"felipe.dioliveira@outlook.com", "123.456.789-01", 
				new GregorianCalendar(2018, Calendar.JULY, 7));
		PessoaJuridica pj = new PessoaJuridica("FIAP", 
				"fiap@fiap.com.br", "098.765.432-01", 
				new GregorianCalendar(2018, Calendar.APRIL, 22));
		
		PessoaDAO pDAO = new PessoaDAOImpl(em);

		pDAO.cadastrar(p);
		pDAO.cadastrar(pf);
		pDAO.cadastrar(pj);
		try {
			pDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}
