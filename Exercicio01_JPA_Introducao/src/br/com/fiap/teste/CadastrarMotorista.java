package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Genero;
import br.com.fiap.bean.Motorista;
import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;

public class CadastrarMotorista {
	
	private static Scanner dados;

	public static void main(String[] args) {
		dados = new Scanner(System.in);
		
		//Criando a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Gerenciador de dados
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		Motorista motorista = new Motorista
				(1515, "Guilherme", new GregorianCalendar(1996, Calendar.JUNE, 6), null, Genero.MASCULINO);
		
		System.out.println("Digite o nome do motorista:");
			motorista.setNome(dados.next()+dados.nextLine());
			
		System.out.println("Digite o número de carteira: ");
			motorista.setCarteira(dados.nextInt());
			
		motorista.setDataNascimento(new GregorianCalendar(1996, Calendar.JUNE, 6));
		
		motorista.setFoto(null);
		
		System.out.println("Gênero - [M] - Masculino"
				+ "[F] - Feminino");
			String genero = dados.next();
			if(genero.equalsIgnoreCase("m")) {
				motorista.setGenero(Genero.MASCULINO);
			}else if(genero.equalsIgnoreCase("f")) {
				motorista.setGenero(Genero.FEMININO);
			}
		
		try {
			//Cadastrar o motorista
			dao.cadastrar(motorista);
			dao.commit();
			
		} catch (Exception e) {
			System.err.println("Erro ao cadastrar o motorista.");
		}
		
	}
	
}
