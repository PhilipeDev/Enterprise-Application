package br.com.fiap.dao;

import br.com.fiap.bean.Veiculo;
import br.com.fiap.exception.CommitException;

public interface VeiculoDAO {
	
	void cadastrar(Veiculo veiculo);
	void excluir(int codigo);
	void atualizar(Veiculo veiculo);
	Veiculo consultar(int codigo);
	
	void commit() throws CommitException;
	void fechar();
	
}
