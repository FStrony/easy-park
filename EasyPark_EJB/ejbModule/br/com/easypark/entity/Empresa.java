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
 * The persistent class for the EP_EMPRESA database table.
 * 
 */
@Entity
@Table(name = "EP_EMPRESA")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_EMPRESA_ID_GENERATOR", sequenceName = "SQ_EP_EMPRESA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_EMPRESA_ID_GENERATOR")
	@Column(name = "CD_EMPRESA")
	private long id;

	@Column(name = "DS_EMAIL", length = 100)
	private String email;

	@Column(name = "DS_PASSWORD", length = 50)
	private String senha;

	@Column(name = "NR_CNPJ")
	private Long cnpj;

	public Empresa() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

}