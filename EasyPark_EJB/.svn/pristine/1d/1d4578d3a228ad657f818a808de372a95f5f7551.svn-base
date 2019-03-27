package br.com.easypark.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.EstacionamentoVeiculo;

@Local
public interface EstacionamentoVeiculoDAO extends
		DAO<EstacionamentoVeiculo, Long> {

	List<EstacionamentoVeiculo> buscarVeiculosPorEstacionamento(
			Estacionamento estacionamento);

}
