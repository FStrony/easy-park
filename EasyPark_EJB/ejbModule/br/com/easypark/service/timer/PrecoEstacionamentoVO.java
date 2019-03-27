package br.com.easypark.service.timer;

public class PrecoEstacionamentoVO {

	private String diaria;
	private String mensal;
	private String hora;
	private String feriado;

	public String getDiaria() {
		return diaria;
	}

	public void setDiaria(String diaria) {
		this.diaria = diaria;
	}

	public String getMensal() {
		return mensal;
	}

	public void setMensal(String mensal) {
		this.mensal = mensal;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFeriado() {
		return feriado;
	}

	public void setFeriado(String feriado) {
		this.feriado = feriado;
	}

}
