package br.com.fiap.dao;

import br.com.fiap.bean.Motorista;
import br.com.fiap.exception.CommitException;

public interface MotoristaDAO {

	void cadastrar(Motorista m);
	Motorista consultar(int codigo);
	void atualizar(Motorista m);
	void remover(int codigo);
	
	void commit() throws CommitException;
	void fechar();
}
