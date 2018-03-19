package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ProfessorDAO;
import br.com.fiap.jpa.dao.impl.ProfessorDAOImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.GrupoAM;
import br.com.fiap.jpa.entity.Professor;
import br.com.fiap.jpa.entity.ProjetoAM;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar o projeto e o grupo, alunos e professores
		ProfessorDAO proDAO = new ProfessorDAOImpl(em);
		
		ProjetoAM projeto = new ProjetoAM(Calendar.getInstance(), 
				"SUS", new GregorianCalendar(2018, Calendar.NOVEMBER, 10));
		
		GrupoAM grupo = new GrupoAM("Quati Sistemas", 0, projeto);
		
		//Adicionando alunos
		Aluno aluno1 = new Aluno("RM79307","Felipe", null);
		Aluno aluno2 = new Aluno("RM78888","Breno", null);
		Aluno aluno3 = new Aluno("RM77985","Pedro", null);
		
		//Adicionando alunos a lista de alunos do grupo
		grupo.adicionarAlunos(aluno1);
		grupo.adicionarAlunos(aluno2);
		grupo.adicionarAlunos(aluno3);
		
		List<ProjetoAM> projetos = new ArrayList<>();
		projetos.add(projeto);
		
		Professor prof1 = new Professor("Thiago", projetos, 3000);
		Professor prof2 = new Professor("Humberto", projetos, 20000);
		
		projeto.setGrupo(grupo);
		
		
		try {
			//pDAO.cadastrar(projeto);
			proDAO.cadastrar(prof1);
			proDAO.cadastrar(prof2);
			proDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao cadastrar o grupo");
		}
		
		em.close();
		fabrica.close();
	}
}
