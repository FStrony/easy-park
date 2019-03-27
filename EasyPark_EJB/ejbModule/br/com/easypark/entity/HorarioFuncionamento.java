package br.com.easypark.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the EP_FUNCIONAMENTO database table.
 * 
 */
@Entity
@Table(name = "EP_FUNCIONAMENTO")
public class HorarioFuncionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_HORARIOFUNC_ID_GENERATOR", sequenceName = "SQ_EP_HORARIOFUNC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_HORARIOFUNC_ID_GENERATOR")
	@Column(name = "CD_HORARIOFUNC")
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Column(name = "HR_FUNCIONAMENTO_FINAL", length = 5)
	private String horarioFuncionamentoFinal;

	@Column(name = "HR_FUNCIONAMENTO_INICIO", length = 5)
	private String horarioFuncionamentoInicio;

	// bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA"),
			@JoinColumn(name = "CD_ESTACIONAMENTO", referencedColumnName = "CD_ESTACIONAMENTO") })
	private Estacionamento estacionamento;

	// bi-directional many-to-one association to TipoDia
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_TIPO_DIA", referencedColumnName = "CD_TIPO_DIA")
	private TipoDia tipoDia;

	public HorarioFuncionamento() {
	}

	public String getHorarioFuncionamentoFinal() {
		return horarioFuncionamentoFinal;
	}

	public void setHorarioFuncionamentoFinal(String horarioFuncionamentoFinal) {
		this.horarioFuncionamentoFinal = horarioFuncionamentoFinal;
	}

	public String getHorarioFuncionamentoInicio() {
		return horarioFuncionamentoInicio;
	}

	public void setHorarioFuncionamentoInicio(String horarioFuncionamentoInicio) {
		this.horarioFuncionamentoInicio = horarioFuncionamentoInicio;
	}

	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public TipoDia getTipoDia() {
		return this.tipoDia;
	}

	public void setTipoDia(TipoDia tipoDia) {
		this.tipoDia = tipoDia;
	}

}