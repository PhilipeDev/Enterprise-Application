package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.ClienteBO;

@ManagedBean
public class ClienteBean {

	private Calendar dataNascimento;
	private int idade;
	
	@EJB
	private ClienteBO bo;
	
	@PostConstruct
	private void init() {
		dataNascimento = Calendar.getInstance();
	}

	public void calcular() { //clique do botão
		idade = bo.calcularIdade(dataNascimento);
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
