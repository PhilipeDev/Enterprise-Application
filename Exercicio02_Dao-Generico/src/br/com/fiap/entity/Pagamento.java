package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

@Entity
@Table(name="T_PAGAMENTO")
@SequenceGenerator(allocationSize=1,name="pagamento",sequenceName="SQ_T_PAGAMENTO")
public class Pagamento {
	
	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(generator="pagamento",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(nullable=false, name="dt_pagamento")
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;
	
	@Column(name="vl_pagamento",nullable=false)
	private float valor;
	
	@Column(name="ds_forma_pagamento",nullable=false)
	private String descricao;
}
