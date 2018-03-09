package br.com.fiap.entity;

import java.util.Calendar;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_AUTOR")
@SequenceGenerator(name="autor", sequenceName="SEQ_T_AUTOR", allocationSize=1)
public class Autor {
	
	@Id
	@Column(name="cd_autor")
	@GeneratedValue(generator="autor", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_autor", nullable=false, length=300)
	private String nome;
	
	@Column(name="ds_genero")
	private Genero genero;
	
	@Column(name="nm_sobrenome")
	private String sobrenome;
	
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
}
