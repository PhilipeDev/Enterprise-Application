package br.com.fiap.dao;

import br.com.fiap.beans.Sala;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public interface SalaDAO {
	
	void cadastrar(Sala sala);
	void excluir(int codigo) throws EntityNotFoundException;
	void atualizar(Sala sala);
	Sala consultar(int codigo);
	
	void commit() throws CommitException;
	void fechar();
	
}
