package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.beans.Sala;
import br.com.fiap.beans.Status;
import br.com.fiap.dao.SalaDAO;
import br.com.fiap.dao.impl.SalaDAOImpl;

public class DaoTeste {
	
	static Scanner dados = new Scanner(System.in);
	
	public static void main(String[] args){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		SalaDAO dao = new SalaDAOImpl(em);
		
		Sala sala = new Sala();
		//CADASTRO
		//Sala sala = new Sala(70, 7, "705", Status.DISPONIVEL, Calendar.getInstance(), null);
		
		System.out.print("Digite a capacidade da sala:");
			sala.setCapacidade(dados.nextInt());
			
		System.out.print("Digite o andar da sala:");
			sala.setAndar(dados.nextInt());
			
		System.out.print("Digite o nome da sala:");
			sala.setNome(dados.nextLine());
		
		sala.setStatus(Status.DISPONIVEL);
		
		sala.setInauguracao(Calendar.getInstance());
		
		sala.setFoto(null);
		
		try {
			dao.cadastrar(sala);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao realizar o commit do cadastrar");
		}

		//PESQUISA
		System.out.println("Digite o código a ser pesquisado:");
			int codigo = dados.nextInt();
			
		dao.consultar(codigo);
		
		//EXCLUSÃO
		System.out.println("Digite o código a ser excluido:");
			int cdDelete = dados.nextInt();
		try {
			dao.excluir(cdDelete);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao realizar o commit da exclusão");
		}
		
		
		//ALTERAÇÃO
		
	}
	
	
	
}
