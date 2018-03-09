package br.com.fiap.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Motorista;
import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;

public class ConsultarMotorista {
	
	private static Scanner dados;

	public static void main(String[] args) {
		dados = new Scanner(System.in);
		
		//Fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Genreciador de dados
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		System.out.println("Digite o código do motorista a ser pesquisado:");
			int codigo = dados.nextInt();
		
		try {
			Motorista motorista = dao.consultar(codigo);
			System.out.println("Motorista: "+ motorista.getNome());
			System.out.println("Número de carteira: "+ motorista.getCarteira());
			System.out.println("Data de nascimento:"+motorista.getDataNascimento());
			System.out.println("Gênero: "+motorista.getGenero());
		} catch (Exception e) {
			System.err.println("Erro ao consultar o motorista");
		}
	}
}
