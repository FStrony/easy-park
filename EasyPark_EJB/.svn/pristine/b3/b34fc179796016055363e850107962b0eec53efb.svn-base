package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.TipoVeiculoDAO;
import br.com.easypark.entity.TipoVeiculo;

@Stateless
public class TipoVeiculoDAOImpl extends DAOImpl<TipoVeiculo, Long> implements
		TipoVeiculoDAO {

	@PersistenceContext(unitName = "CLIENTE_ORACLE")
	private EntityManager em;

	@Override
	public List<TipoVeiculo> buscarTodos() {
		TypedQuery<TipoVeiculo> query = em.createQuery("from TipoVeiculo",
				TipoVeiculo.class);
		return query.getResultList();
	}

}
