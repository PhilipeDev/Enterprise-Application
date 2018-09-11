package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_PEDIDO")
@IdClass(ItemPedidoPK.class)
public class ItemPedido {
	
	@Id
	@JoinColumn(name="cd_pedido")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Pedido pedido;
	
	@Id
	@JoinColumn(name="cd_produto")
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Produto produto;
	
	@Column(name="vl_item")
	private float valor;
	
	@Column(name="qt_item")
	private int quantidade;

	
	//Construtor Vazio
	public ItemPedido() {
	}

	//Construtor Cheio
	public ItemPedido(Pedido pedido, Produto produto, float valor, int quantidade) {
		setPedido(pedido);
		setProduto(produto);
		setValor(valor);
		setQuantidade(quantidade);
	}

	//Getter's and Setter's
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
