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
 * The persistent class for the EP_TIPO_TELEFONE database table.
 * 
 */
@Entity
@Table(name = "EP_TIPO_TELEFONE")
public class TipoTelefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_TIPO_TELEFONE_ID_GENERATOR", sequenceName = "SQ_EP_TIPO_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_TIPO_TELEFONE_ID_GENERATOR")
	@Column(name = "CD_TIPO_TELEFONE")
	private Long id;

	@Column(name = "DS_TIPO_TELEFONE", length = 40)
	private String descricao;

	public TipoTelefone() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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