package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import br.com.fiap.bean.Motorista;
import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.exception.CommitException;

public class MotoristaDAOImpl implements MotoristaDAO{

	private EntityManager em;
		
	//Importante
	public MotoristaDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void cadastrar(Motorista m) {
	
		em.persist(m);
	}

	@Override
	public Motorista consultar(int codigo) {
		// TODO Auto-generated method stub
		Motorista motorista = em.find(Motorista.class, codigo);
		
		return motorista;
	}

	@Override
	public void atualizar(Motorista m) {
		
		em.merge(m);
	}

	@Override
	public void remover(int codigo) {
		// TODO Auto-generated method stub
		Motorista motorista = consultar(codigo);
		
		if(motorista == null)
			throw new EntityNotFoundException("Entidade não encontrada.");
		
		em.remove(motorista);
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit.");
		}
	}

	@Override
	public void fechar() {
		em.close();
		
	}
	
}
