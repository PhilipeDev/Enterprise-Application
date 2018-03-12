package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProjetoAmDAO;
import br.com.fiap.jpa.entity.ProjetoAM;

public class ProjetoAmDAOImpl extends GenericDAOImpl<ProjetoAM, Integer> implements ProjetoAmDAO{

	public ProjetoAmDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
}
