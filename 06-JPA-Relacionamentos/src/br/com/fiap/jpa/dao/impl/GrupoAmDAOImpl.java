package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GrupoAmDAO;
import br.com.fiap.jpa.entity.GrupoAM;

public class GrupoAmDAOImpl extends GenericDAOImpl<GrupoAM, Integer> implements GrupoAmDAO{

	public GrupoAmDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
}
