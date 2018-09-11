package br.com.fiap.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.fiap.bo.CarrinhoBO;

@Stateful
public class CarrinhoBOImpl implements CarrinhoBO {

	private List<String> lista = new ArrayList<String>();
	
	@Override
	public void adicionar(String churros) {
		lista.add(churros);
	}

	@Override
	public List<String> listar() {
		return lista;
	}
	
}
