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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_GRUPOAM")
@SequenceGenerator(name="grupo",sequenceName="SEQ_T_GRUPO",allocationSize=1)
public class GrupoAM {
	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(generator="grupo", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_grupo", length=50, nullable=false)
	private String nome;
	
	@Column(name="vl_nota")
	private float nota;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_cd_projeto", nullable=false)
	private ProjetoAM projeto;

	@OneToMany(mappedBy="grupo", cascade=CascadeType.PERSIST)
	private List<Aluno> alunos = new ArrayList<>();
	
	public void adicionarAlunos(Aluno aluno) {
		alunos.add(aluno);
		aluno.setGrupo(this);
	}
	
	//Construtor Cheio
	public GrupoAM(String nome, float nota, ProjetoAM projeto) {
		setNome(nome);
		setNota(nota);
		setProjeto(projeto);
	}

	//Construtor Vazio
	public GrupoAM() {
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

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public ProjetoAM getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoAM projeto) {
		this.projeto = projeto;
	}
	
	
	
	
	
	
	
}
