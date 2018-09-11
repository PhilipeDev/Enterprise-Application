package br.com.fiap.nac.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.nac.dao.LivroDAO;

public class LivroDAOImpl extends GenericDAOImpl<Livro, String>
									implements LivroDAO{

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> buscarPorTitulo(String titulo) {
		return em.createQuery(
				"from Livro where titulo like :churros",Livro.class)
				.setParameter("churros", "%"+ titulo + "%")
				.setMaxResults(50)
				.getResultList();
	}

	@Override
	public long contarPorEditora(int codigoEditora) {
		return em.createQuery(
				"select count(e) from Livro e where e.editora.codigo "
				+ "= :churros",Long.class)
				.setParameter("churros", codigoEditora)
				.getSingleResult();
	}

	@Override
	public List<Livro> buscarPorNomeEditora(String editora) {
		return em.createQuery(
				"from Livro l where l.editora.nome like :churros",
				Livro.class)
				.setParameter("churros", "%"+editora+"%")
				.getResultList();
	}

}





