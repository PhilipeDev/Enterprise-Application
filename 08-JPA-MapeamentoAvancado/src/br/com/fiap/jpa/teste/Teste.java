package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Medico medico = new Medico(123,"Joaquim", 1000);
		Paciente paciente = new Paciente(0 , "Juliana " , new GregorianCalendar(1999, Calendar.JANUARY,2));
		Consulta consulta = new Consulta(Calendar.getInstance(), paciente, medico, "Consulta", true);
				
		ConsultaDAO consultaDAO = new ConsultaDAOImpl(em);
		
		try {
			consultaDAO.cadastrar(consulta);
			consultaDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		fabrica.close();
	}

}
