package br.com.fiap.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class ConsoleView {

	public static void main(String[] args) {
		//Testar a listagem de cliente
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		List<Cliente> lista = clienteDao.listar();
		System.out.println("|---------------------------|");
		//Exibir os clientes
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		System.out.println("|---------------------------|");
		System.out.println("BUSCAR POR NOME");
		lista = clienteDao.buscarPorNome("ia");
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		System.out.println("|---------------------------|");
		System.out.println("BUSCAR POR ESTADO");
		lista = clienteDao.buscarPorEstado("BA");
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		System.out.println("|---------------------------|");
		System.out.println("BUSCAR POR QTD DIAS RESERVA");
		lista = clienteDao.buscarPorDiasReserva(10);
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		System.out.println("|---------------------------|");
		System.out.println("TOTAL DE CLIENTES: ");
		System.out.println(clienteDao.contarTotal());
		
		System.out.println("|---------------------------|");
		System.out.println("BUSCANDO CLIENTE POR NOME E CIDADE");
		lista = clienteDao.buscar("a", "a");
		for(Cliente cliente : lista) {
			System.out.println("Cliente: " + cliente.getNome() + " - Cidade: " +cliente.getEndereco().getCidade().getNome());
		}
		
		System.out.println("|---------------------------|");
		System.out.println("BUSCANDO POR UMA LISTA DE ESTADOS");
		List<String> estados = new ArrayList<String>();
		estados.add("SP");
		estados.add("BA");
		estados.add("RJ");
		estados.add("MG");
		lista = clienteDao.buscarPorEstados(estados);
		for(Cliente cliente : lista) {
			System.out.println("Cliente: " + cliente.getNome() + " - Cidade: " +cliente.getEndereco().getCidade().getUf());
		}
		
		System.out.println("|---------------------------|");
		System.out.println("Contagem de Reservas");
		double contagem = clienteDao.contarReservas(5);
		System.out.println("Resultado da contagem: "+ contagem);
		
		
		em.close();
		fabrica.close();
	}

}



