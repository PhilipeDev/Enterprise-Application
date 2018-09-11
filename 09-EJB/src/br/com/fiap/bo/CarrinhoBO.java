package br.com.fiap.bo;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CarrinhoBO {

	void adicionar(String churros);
	
	List<String> listar();
	
}
