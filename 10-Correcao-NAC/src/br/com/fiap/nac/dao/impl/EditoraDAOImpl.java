package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Editora;
import br.com.fiap.nac.dao.EditoraDAO;

public class EditoraDAOImpl extends GenericDAOImpl<Editora, Integer>
					implements EditoraDAO{

	public EditoraDAOImpl(EntityManager em) {
		super(em);
	}

}
