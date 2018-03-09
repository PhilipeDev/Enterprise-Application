package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CHURROS")
@SequenceGenerator(name="churros", sequenceName="SQ_T_CHURROS", allocationSize=1)
public class Churros {
	
	@Id
	@Column(name="cd_churros")
	@GeneratedValue(generator="churros", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_sabor", nullable=false, length=20)
	private String sabor;

	@Column(name="vl_churros", nullable=false)
	private float valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoPedido tipo;
	
	
	//Construtor Cheio
	public Churros(String sabor, float valor, TipoPedido tipo) {
		super();
		setSabor(sabor);
		setValor(valor);
		setTipo(tipo);
	}
	
	//Construtor Vazio
	public Churros() {
		super();
	}


	//Getter's and Setter's
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public TipoPedido getTipo() {
		return tipo;
	}
	public void setTipo(TipoPedido tipo) {
		this.tipo = tipo;
	}
	
	
	
}
