package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_CONSULTA")
@IdClass(ConsultaPK.class)
public class Consulta {

	@Id
	@Temporal(TemporalType.DATE)
	private Calendar data;

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_paciente")
	private Paciente paciente;

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "nr_crm")
	private Medico medico;

	@Column(name = "ds_consultorio")
	private String consultorio;

	@Column(name = "st_convenio")
	private boolean convenio;

	
	
	public Consulta() {
		super();
	}

	public Consulta(Calendar data, Paciente paciente, Medico medico, String consultorio, boolean convenio) {
		super();
		setData(data);
		setPaciente(paciente);
		setMedico(medico);
		setConsultorio(consultorio);
		setConvenio(convenio);
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}

}
