package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.HorarioDAO;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.HorarioFuncionamento;

@Stateless
public class HorarioDAOImpl extends DAOImpl<HorarioFuncionamento, Long>
		implements HorarioDAO {

	@Override
	public List<HorarioFuncionamento> buscarHorariosPorEstacionamento(
			Estacionamento estacionamento) {
		TypedQuery<HorarioFuncionamento> query = em
				.createQuery(
						"from HorarioFuncionamento hf where hf.estacionamento.id = :idEstacionamento",
						HorarioFuncionamento.class);
		query.setParameter("idEstacionamento", estacionamento.getId());
		return query.getResultList();
	}

}
