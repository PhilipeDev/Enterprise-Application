package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida",sequenceName="SEQ_T_CORRIDA",allocationSize=1)
public class Corrida {
	
	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_origem", length=150)
	private String origem;
	
	@Column(name="ds_destino", length=150)
	private String destino;
	
	@Column(name="dt_corrida")
	private Calendar dt_corrida;
	
	@Column(name="vl_corrida", nullable=false)
	private float valor;

}	
