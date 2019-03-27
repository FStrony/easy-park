package br.com.easypark.entity;

import java.io.Serializable;

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
 * The persistent class for the EP_TELEFONE database table.
 * 
 */
@Entity
@Table(name = "EP_TELEFONE")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_TELEFONE_ID_GENERATOR", sequenceName = "SQ_EP_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_TELEFONE_ID_GENERATOR")
	@Column(name = "CD_TELEFONEESTAC")
	private Long id;

	@Column(name = "NR_DDD")
	private Integer ddd;

	@Column(name = "NR_TELEFONE")
	private Long numero;

	// bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA"),
			@JoinColumn(name = "CD_ESTACIONAMENTO", referencedColumnName = "CD_ESTACIONAMENTO") })
	private Estacionamento estacionamento;

	// bi-directional many-to-one association to TipoTelefone
	@ManyToOne
	@JoinColumn(name = "CD_TIPO_TELEFONE", referencedColumnName = "CD_TIPO_TELEFONE")
	private TipoTelefone tipoTelefone;

	public Telefone() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDdd() {
		return this.ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public TipoTelefone getTipoTelefone() {
		return this.tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

}