package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PROJETO")
@SequenceGenerator(name="projeto", sequenceName="SEQ_T_PROJETO", allocationSize=1)
public class ProjetoAM {
	
	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(generator="projeto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_projeto", length=100, nullable=false)
	private String nome;
	@Column(name="dt_inicio", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Calendar dataFim;
	
	//Criando o atributo GrupoAM e mapeando-o para ser bidimensional.
	@OneToOne(mappedBy="projeto", cascade=CascadeType.PERSIST)
	private GrupoAM grupo;
	
	//Lista de professores adicionadas para o mapeamento BIDIMENSIONAL
	//MappedBy sempre se refere ao atributo da outra classe onde foi definido.
	@ManyToMany(mappedBy="projetos", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<Professor> professores = new ArrayList<>();
	
	
	
	//Construtor Cheio
	public ProjetoAM(Calendar dataInicio,String nome, Calendar dataFim) {
		setDataInicio(dataInicio);
		setNome(nome);
		setDataFim(dataFim);
	}

	//Getter's and Setter's
	public GrupoAM getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAM grupo) {
		this.grupo = grupo;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
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

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
