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
 * The persistent class for the EP_VALOR database table.
 * 
 */
@Entity
@Table(name = "EP_VALOR")
public class Valor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_VALOR_ID_GENERATOR", sequenceName = "SQ_EP_VALOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_VALOR_ID_GENERATOR")
	@Column(name = "CD_VALOR")
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "VL_HORA")
	private BigDecimal hora;

	// bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA"),
			@JoinColumn(name = "CD_ESTACIONAMENTO", referencedColumnName = "CD_ESTACIONAMENTO") })
	private Estacionamento estacionamento;

	// bi-directional many-to-one association to TipoDia
	@ManyToOne
	@JoinColumn(name = "CD_TIPO_DIA")
	private TipoDia tipoDia;

	// bi-directional many-to-one association to TipoVeiculo
	@ManyToOne
	@JoinColumn(name = "CD_TIPO_VEICULO")
	private TipoVeiculo tipoVeiculo;

	public Valor() {
	}

	public BigDecimal getHora() {
		return this.hora;
	}

	public void setHora(BigDecimal hora) {
		this.hora = hora;
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

	public TipoVeiculo getTipoVeiculo() {
		return this.tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

}