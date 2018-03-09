package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import br.com.fiap.bean.Veiculo;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.exception.CommitException;

public class VeiculoDAOImpl implements VeiculoDAO{

	private EntityManager em;

	
	//Importante
	public VeiculoDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void cadastrar(Veiculo veiculo) {
		
		em.persist(veiculo);
	}

	@Override
	public void excluir(int codigo) throws EntityNotFoundException{
		
		Veiculo veiculo = consultar(codigo);
		
		if(veiculo == null) {
			throw new EntityNotFoundException("Entidade não encontrada.");
		}
		
		em.remove(veiculo);
	}

	@Override
	public void atualizar(Veiculo veiculo) {
		
		em.merge(veiculo);
	}

	@Override
	public Veiculo consultar(int codigo) {
		
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		
		return veiculo;
	}

	@Override
	public void commit() throws CommitException{
		
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		}
		
	}

	@Override
	public void fechar() {
		em.close();
		
	}
	

}
