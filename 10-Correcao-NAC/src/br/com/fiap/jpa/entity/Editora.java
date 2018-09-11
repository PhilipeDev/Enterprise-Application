package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC_EDITORA")
@SequenceGenerator(name="editora",sequenceName="SQ_T_NAC_EDITORA",allocationSize=1)
public class Editora {

	@Id
	@Column(name="cd_editora")
	@GeneratedValue(generator="editora",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_editora",nullable=false,length=60)
	private String nome;
	
	@OneToMany(mappedBy="editora")
	private List<Livro> livros;
	
	public Editora() {
		super();
	}
	
	public Editora(String nome) {
		super();
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}
