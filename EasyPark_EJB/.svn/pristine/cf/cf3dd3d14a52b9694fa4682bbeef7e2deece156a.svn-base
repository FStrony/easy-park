package br.com.easypark.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.Empresa;
import br.com.easypark.entity.EnderecoEstacionamento;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.service.timer.EstacionamentoVO;

@Local
public interface EstacionamentoDAO extends DAO<Estacionamento, Long> {

	List<Estacionamento> buscarTodos();

	List<Estacionamento> buscarEstacionamentosPorEmpresa(Empresa empresa);

	List<Estacionamento> buscarEstacionamento(String nome);

	Estacionamento buscarEstacionamentoPorEndereco(
			EnderecoEstacionamento enderecoEstacionamento);

	List<EstacionamentoVO> buscaTodosEstacionamentos();

	Long getQuantidadeVagasCarroPorEstacionamento(Long idEstacionamento);

	List<Object[]> getValoresEstacionamento(Long idEstacionamento);

	BigDecimal getValorHoraPorDiaUtilECarro(Long idEstacionamento);
}
