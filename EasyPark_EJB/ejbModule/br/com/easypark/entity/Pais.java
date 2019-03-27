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
 * The persistent class for the EP_PAIS database table.
 * 
 */
@Entity
@Table(name = "EP_PAIS")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_PAIS_ID_GENERATOR", sequenceName = "SQ_EP_PAIS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_PAIS_ID_GENERATOR")
	@Column(name = "CD_PAIS")
	private long id;

	@Column(name = "DS_PAIS", length = 60)
	private String nome;

	public Pais() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

}