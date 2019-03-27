package br.com.easypark.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the EP_TIPO_DIA database table.
 * 
 */
@Entity
@Table(name = "EP_TIPO_DIA")
public class TipoDia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_TIPO_DIA_ID_GENERATOR", sequenceName = "SQ_EP_TIPO_DIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_TIPO_DIA_ID_GENERATOR")
	@Column(name = "CD_TIPO_DIA")
	private long id;

	@Column(name = "DS_TIPO_DIA", length = 40)
	private String descricao;

	public TipoDia() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}