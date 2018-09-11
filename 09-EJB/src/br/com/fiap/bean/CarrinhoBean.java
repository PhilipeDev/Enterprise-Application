package br.com.fiap.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.bo.CarrinhoBO;

@ManagedBean
@SessionScoped
public class CarrinhoBean {

	private String churro;
	private List<String> lista;

	@EJB
	public CarrinhoBO bo;
	
	public void adicionar() {
		bo.adicionar(churro);
		lista = bo.listar(); //Atualizar a lista
	}
	
	public String getChurro() {
		return churro;
	}

	public void setChurro(String churro) {
		this.churro = churro;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

}
