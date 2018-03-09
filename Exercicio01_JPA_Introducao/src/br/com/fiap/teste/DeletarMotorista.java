package br.com.fiap.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;

public class DeletarMotorista {
	
	

	public static void main(String[] args) {
		Scanner dados = new Scanner(System.in);
		
		//Fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Gerenciador de dados
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		try {
			//Remover o motorista
			int codigo;
			
			System.out.println("Digite o código do motorista a ser removido:");
				codigo = dados.nextInt();
				
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
			System.err.println("Erro ao remover o motorista.");	
		}
		
	}
}
