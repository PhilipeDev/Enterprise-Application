package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> listar();
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorDiasReserva(int dias);
	
	List<Cliente> buscar (String nome, String cidade);
	
	long contarTotal();
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	long contarReservas(int codigo);

	
}