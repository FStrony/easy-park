package br.com.easypark.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the EP_ESTACIONAMENTO_VEICULO database table.
 * 
 */
@Entity
@Table(name = "EP_ESTACIONAMENTO_VEICULO")
public class EstacionamentoVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_ESTACVEICULO_ID_GENERATOR", sequenceName = "SQ_EP_ESTACVEICULO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_ESTACVEICULO_ID_GENERATOR")
	@Column(name = "CD_ESTACVEICULO")
	private Long id;

	@Column(name = "QTD_VAGAS")
	private Integer quantidadeVagas;

	@Column(name = "VL_DIARIA")
	private BigDecimal diaria;

	@Column(name = "VL_MENSAL")
	private BigDecimal mensal;

	@Column(name = "VL_SEMESTRAL")
	private BigDecimal semestral;

	// one-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA"),
			@JoinColumn(name = "CD_ESTACIONAMENTO", referencedColumnName = "CD_ESTACIONAMENTO") })
	private Estacionamento estacionamento;

	// bi-directional many-to-one association to TipoVeiculo
	@ManyToOne
	@JoinColumn(name = "CD_TIPO_VEICULO")
	private TipoVeiculo tipoVeiculo;

	public EstacionamentoVeiculo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidadeVagas() {
		return this.quantidadeVagas;
	}

	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public TipoVeiculo getTipoVeiculo() {
		return this.tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public BigDecimal getDiaria() {
		return diaria;
	}

	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}

	public BigDecimal getMensal() {
		return mensal;
	}

	public void setMensal(BigDecimal mensal) {
		this.mensal = mensal;
	}

	public BigDecimal getSemestral() {
		return semestral;
	}

	public void setSemestral(BigDecimal semestral) {
		this.semestral = semestral;
	}

}