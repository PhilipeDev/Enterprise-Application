package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Genero;
import br.com.fiap.bean.Motorista;
import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;

public class AtualizarMotorista {
	
	public static void main(String[] args) {
		//Fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Gerenciador de dados
		EntityManager em = fabrica.createEntityManager();
		
		//Passando o gerenciador de dados
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		
		Motorista motorista = new Motorista
				(79307, "Felipe", new GregorianCalendar(1997, Calendar.JULY, 7), null, Genero.MASCULINO);
		
		try {
			Motorista motoristaBusca = dao.consultar(motorista.getCarteira());
			
			motoristaBusca.setNome("Philipe");
			dao.atualizar(motoristaBusca);
			dao.commit();
		} catch (Exception e) {
			System.err.println("Erro ao atualizar o motorista");
		}
		
	}
}
