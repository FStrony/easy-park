package br.com.easypark.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the EP_ESTACIONAMENTO database table.
 * 
 */
@Entity
@Table(name = "EP_ESTACIONAMENTO")
public class Estacionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EP_ESTAC_ID_GENERATOR", sequenceName = "SQ_EP_ESTACIONAMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EP_ESTAC_ID_GENERATOR")
	@Column(name = "CD_ESTACIONAMENTO")
	private Long id;

	@Column(name = "DS_EMAIL", length = 100)
	private String email;

	@Column(name = "DS_NOME", length = 100)
	private String nome;

	@Column(name = "DS_SEGURO")
	private Boolean isSeguro;

	@Column(name = "DS_SITE", length = 100)
	private String site;

	// one-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name = "CD_EMPRESA")
	private Empresa empresa;

	// bi-directional many-to-one association to EnderecoEstacionamento
	@OneToOne(mappedBy = "estacionamento", cascade = CascadeType.ALL)
	private EnderecoEstacionamento enderecoEstacionamento;

	// bi-directional many-to-one association to HorarioFuncionamento
	@OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL)
	private List<HorarioFuncionamento> horariosFuncionamento = new ArrayList<HorarioFuncionamento>();

	// bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy = "estacionamento", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();

	// bi-directional many-to-one association to EstacionamentoVeiculo
	@OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL)
	private List<EstacionamentoVeiculo> estacionamentoVeiculo = new ArrayList<EstacionamentoVeiculo>();

	// bi-directional many-to-one association to Valores
	@OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL)
	private List<Valor> valores = new ArrayList<Valor>();

	public Estacionamento() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsSeguro() {
		return this.isSeguro;
	}

	public void setIsSeguro(Boolean isSeguro) {
		this.isSeguro = isSeguro;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EnderecoEstacionamento getEnderecoEstacionamento() {
		return this.enderecoEstacionamento;
	}

	public void setEnderecoEstacionamento(
			EnderecoEstacionamento enderecoEstacionamento) {
		this.enderecoEstacionamento = enderecoEstacionamento;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefoneEstacionamento(Telefone telefone) {
		getTelefones().add(telefone);
		telefone.setEstacionamento(this);

		return telefone;
	}

	public Telefone removeTelefoneEstacionamento(Telefone telefone) {
		getTelefones().remove(telefone);
		telefone.setEstacionamento(null);

		return telefone;
	}

	public List<HorarioFuncionamento> getHorariosFuncionamento() {
		return this.horariosFuncionamento;
	}

	public void setHorariosFuncionamento(
			List<HorarioFuncionamento> horariosFuncionamento) {
		this.horariosFuncionamento = horariosFuncionamento;
	}

	public HorarioFuncionamento addHorarioFuncionamento(
			HorarioFuncionamento horariosFuncionamento) {
		getHorariosFuncionamento().add(horariosFuncionamento);
		horariosFuncionamento.setEstacionamento(this);

		return horariosFuncionamento;
	}

	public HorarioFuncionamento removeHorarioFuncionamento(
			HorarioFuncionamento horariosFuncionamento) {
		getHorariosFuncionamento().remove(horariosFuncionamento);
		horariosFuncionamento.setEstacionamento(null);

		return horariosFuncionamento;
	}

	public List<EstacionamentoVeiculo> getEstacionamentoVeiculo() {
		return estacionamentoVeiculo;
	}

	public void setEstacionamentoVeiculo(
			List<EstacionamentoVeiculo> estacionamentoVeiculo) {
		this.estacionamentoVeiculo = estacionamentoVeiculo;
	}

	public EstacionamentoVeiculo addEstacionamentoVeiculo(
			EstacionamentoVeiculo estacionamentoVeiculo) {
		getEstacionamentoVeiculo().add(estacionamentoVeiculo);
		estacionamentoVeiculo.setEstacionamento(this);
		return estacionamentoVeiculo;
	}

	public EstacionamentoVeiculo removeEstacionamentoVeiculo(
			EstacionamentoVeiculo estacionamentoVeiculo) {
		getEstacionamentoVeiculo().remove(estacionamentoVeiculo);
		estacionamentoVeiculo.setEstacionamento(null);

		return estacionamentoVeiculo;
	}

	public Valor addValorHoraEstacionamento(Valor valor) {
		getValores().add(valor);
		valor.setEstacionamento(this);
		return valor;
	}

	public Valor removeValorHoraEstacionamento(Valor valor) {
		getValores().remove(valor);
		valor.setEstacionamento(null);

		return valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Valor> getValores() {
		return valores;
	}

	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}

	@Override
	public String toString() {
		return "nome=" + this.nome;
	}
}