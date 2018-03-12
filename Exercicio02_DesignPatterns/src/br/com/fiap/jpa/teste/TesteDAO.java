package br.com.fiap.jpa.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import javassist.compiler.SyntaxError;

public class TesteDAO {
	private static Scanner dados;
	
	public static void main(String[] args) {
		dados = new Scanner(System.in);
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO vDAO = new VeiculoDAOImpl(em);
		
		Veiculo veiculo = new Veiculo("HAF-9090", "Preto", 1997);
		
		//Cadastrar
		try {
			vDAO.cadastrar(veiculo);
			vDAO.commit();
		} catch (Exception e) {
			System.err.println("Erro ao cadastrar o veiculo");
		}
		
		//Consultar
		System.out.println("Digite o número do veículo a ser pesquisado:");
			int codigo = dados.nextInt();
			
		Veiculo veiculoBusca = vDAO.consultar(codigo);
		System.out.println("Placa:"+veiculoBusca.getPlaca());
		System.out.println("Cor:"+veiculoBusca.getCor());
		System.out.println("Ano:"+veiculoBusca.getAno());
		
		//Atualizar
		System.out.println("Digite o código do veiculo a ser atualizado:");
			int codigoAtualiza = dados.nextInt();
		try {
			Veiculo veiculoAtualiza = vDAO.consultar(codigoAtualiza);
			int escolha;
			System.out.println("Escolha o atributo que irá ser atualizado -"+"\n"
			+"[1] - Placa"+"\n"+
			"[2] - Cor"+"\n"+
			"[3] - Ano"+"\n"+"Escolha:");
			 	escolha = dados.nextInt();
			
			if(escolha == 1) {
				int novoAno;
				//FAZER veiculoAtualiza.setAno(novoAno);
			}
			System.out.println("");
			
			vDAO.atualizar(veiculoAtualiza);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Remover
	}
}
