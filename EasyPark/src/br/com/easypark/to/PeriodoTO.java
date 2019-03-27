package br.com.easypark.to;

import java.util.List;

/**
 * Esta classe tem por objetivo inserir e retornar as informacoes do periodo de funcionamento do estacionamento
 * 
 * @author ExceptionIT
 * @since 20/04/2013
 * @version 2.0
 */
public class PeriodoTO {

	private long idHorarioFuncionamento;
	private String descricaoHorarioFuncionamento;

	private List<TipoVeiculoTO> tipoVeiculoTO;

	public long getIdHorarioFuncionamento() {
		return idHorarioFuncionamento;
	}

	public void setIdHorarioFuncionamento(long idHorarioFuncionamento) {
		this.idHorarioFuncionamento = idHorarioFuncionamento;
	}

	public List<TipoVeiculoTO> getTipoVeiculoTO() {
		return tipoVeiculoTO;
	}

	public void setTipoVeiculoTO(List<TipoVeiculoTO> tipoVeiculoTO) {
		this.tipoVeiculoTO = tipoVeiculoTO;
	}

	public String getDescricaoHorarioFuncionamento() {
		return descricaoHorarioFuncionamento;
	}

	public void setDescricaoHorarioFuncionamento(
			String descricaoHorarioFuncionamento) {
		this.descricaoHorarioFuncionamento = descricaoHorarioFuncionamento;
	}

}