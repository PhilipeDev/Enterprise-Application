package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProfessorDAO;
import br.com.fiap.jpa.entity.Professor;

public class ProfessorDAOImpl extends GenericDAOImpl<Professor, Integer> implements ProfessorDAO{

	public ProfessorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
