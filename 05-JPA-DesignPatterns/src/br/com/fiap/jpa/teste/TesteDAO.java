package br.com.fiap.jpa.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.ChurrosDAO;
import br.com.fiap.jpa.dao.impl.ChurrosDAOImpl;
import br.com.fiap.jpa.entity.Churros;
import br.com.fiap.jpa.entity.TipoPedido;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteDAO {
	
	private static Scanner dados;

	public static void main(String[] args) {
		dados = new Scanner(System.in);
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ChurrosDAO dao = new ChurrosDAOImpl(em);
		Churros churros = new Churros("Chocolate", 5.55f, TipoPedido.VIAGEM);
		
		//Cadastrar
		try {
			dao.cadastrar(churros);
			dao.commit();
		} catch (Exception e) {
			System.err.println("Cadastro não foi realizado.");
		}
		
		//Consultar
		System.out.print("Digite o código do churros a ser pesquisado: ");
			int codigo = dados.nextInt();
		try {
			Churros churrosBusca = dao.consultar(codigo);
			
			System.out.println("Sabor: "+churrosBusca.getSabor());
			System.out.println("Valor: "+churrosBusca.getValor());
			System.out.println("Tipo do pedido: "+churrosBusca.getTipo());
		} catch (Exception e) {
			System.err.println("Churros não encontrado");
		}
		
		//Atualizar
		try {
			churros.setSabor("Morango");
			dao.atualizar(churros);
			dao.commit();
		} catch (Exception e) {
			System.err.println("Erro ao atualizar o churros.");
		}
		
		//Remover
		try {
			System.out.println("Digite o código do churros a ser removido: ");
				int codigoRemover = dados.nextInt();
			
			dao.remover(codigoRemover);
			dao.commit();
		} catch (Exception e) {
			System.err.println("Erro ao remover o churros.");
		}
	}
}
