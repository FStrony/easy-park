package br.com.easypark.service.timer;

public class DetalheEstacionamentoVO {

	private String nome;
	private String vagas;
	private PrecoEstacionamentoVO precos;
	private HorarioEstacionamentoVO horarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVagas() {
		return vagas;
	}

	public void setVagas(String vagas) {
		this.vagas = vagas;
	}

	public PrecoEstacionamentoVO getPrecos() {
		return precos;
	}

	public void setPrecos(PrecoEstacionamentoVO precos) {
		this.precos = precos;
	}

	public HorarioEstacionamentoVO getHorarios() {
		return horarios;
	}

	public void setHorarios(HorarioEstacionamentoVO horarios) {
		this.horarios = horarios;
	}

}
