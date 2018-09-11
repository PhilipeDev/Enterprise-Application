package br.com.fiap.nac.dao;

import java.util.List;

import br.com.fiap.jpa.entity.Livro;

public interface LivroDAO extends GenericDAO<Livro, String> {

	List<Livro> buscarPorTitulo(String titulo);
	
	long contarPorEditora(int codigoEditora);
	
	List<Livro> buscarPorNomeEditora(String editora);
	
}