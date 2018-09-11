package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>)
				((ParameterizedType) 
					getClass().getGenericSuperclass())
								.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(K chave) throws IdNotFoundException {
		T entidade = buscar(chave);
		if (entidade == null)
			throw new IdNotFoundException("Entidade não encontrada");
		em.remove(entidade);
	}

	@Override
	public T buscar(K chave) {
		return em.find(clazz, chave);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
		
	}

}








