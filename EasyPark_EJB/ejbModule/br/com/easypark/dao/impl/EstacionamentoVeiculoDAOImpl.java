package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.EstacionamentoVeiculoDAO;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.EstacionamentoVeiculo;

@Stateless
public class EstacionamentoVeiculoDAOImpl extends
		DAOImpl<EstacionamentoVeiculo, Long> implements
		EstacionamentoVeiculoDAO {

	@Override
	public List<EstacionamentoVeiculo> buscarVeiculosPorEstacionamento(
			Estacionamento estacionamento) {
		TypedQuery<EstacionamentoVeiculo> query = em
				.createQuery(
						"from EstacionamentoVeiculo ev where ev.estacionamento.id = :idEstacionamento",
						EstacionamentoVeiculo.class);
		query.setParameter("idEstacionamento", estacionamento.getId());
		return query.getResultList();
	}

}
