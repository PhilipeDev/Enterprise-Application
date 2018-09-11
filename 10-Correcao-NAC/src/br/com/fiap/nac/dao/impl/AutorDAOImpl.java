package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Autor;
import br.com.fiap.nac.dao.AutorDAO;

public class AutorDAOImpl extends GenericDAOImpl<Autor, Integer>
													implements AutorDAO{

	public AutorDAOImpl(EntityManager em) {
		super(em);
	}

}
