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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the EP_ESTAC_END database table.
 * 
 */
@Entity
@Table(name = "EP_ESTAC_END")
public class EnderecoEstacionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_ENDESTAC_ID_GENERATOR", sequenceName = "SQ_EP_ENDERECOESTAC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_ENDESTAC_ID_GENERATOR")
	@Column(name = "ID_ENDERECOESTAC")
	private Long id;

	@Column(name = "DS_COMPLEMENTO", length = 100)
	private String complemento;

	@Column(name = "NR_CEP", length = 12)
	private String cep;

	@Column(name = "LOGRADOURO", length = 150)
	private String logradouro;

	@Column(name = "NR_ENDERECO")
	private Integer numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "latitude", length = 100)
	private String latitude;

	@Column(name = "longitude", length = 100)
	private String longitude;

	// bi-directional many-to-one association to Estacionamento
	@OneToOne
	@JoinColumns({

	@JoinColumn(name = "CD_ESTACIONAMENTO", referencedColumnName = "CD_ESTACIONAMENTO") })
	private Estacionamento estacionamento;

	// bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name = "CD_PAIS")
	private Pais pais;

	public EnderecoEstacionamento() {
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}