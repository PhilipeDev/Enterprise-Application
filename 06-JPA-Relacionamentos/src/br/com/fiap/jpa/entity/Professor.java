package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PROFESSOR")
@SequenceGenerator(name="professor", allocationSize=1, sequenceName="SEQ_T_PROFESSOR")
public class Professor {
	
	@Id
	@Column(name="cd_professor")
	@GeneratedValue(generator="professor", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_professor", nullable=false, length=50)
	private String nome;
	
	@Column(name="vl_salario", nullable=false)
	private double salario;
	
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	//JoinTable se refere a tabela associativa.
	//JoinColumn é o código da tabela está sendo referenciado. (Tabela onde estamos)
	//InverseJoinColumn é o código da outra tabela relacionada.
	@JoinTable(name="T_PROFESSOR_PROJETO", 
				joinColumns=@JoinColumn(name="cd_professor"),
				inverseJoinColumns=@JoinColumn(name="cd_projeto"))
	List<ProjetoAM> projetos = new ArrayList<>();

	
	//Construtor Cheio
	public Professor(String nome, List<ProjetoAM> projetos, double salario) {
		super();
		setNome(nome);
		setProjetos(projetos);
		setSalario(salario);
	}
	
	//Construtor Vazio
	public Professor() {
		super();
	}

	//Getter's and Setter's
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

	public List<ProjetoAM> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<ProjetoAM> projetos) {
		this.projetos = projetos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
