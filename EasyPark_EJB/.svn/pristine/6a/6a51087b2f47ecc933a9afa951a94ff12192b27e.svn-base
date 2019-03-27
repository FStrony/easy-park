package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.ValorDAO;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.Valor;

@Stateless
public class ValorDAOImpl extends DAOImpl<Valor, Long> implements ValorDAO {

	@Override
	public List<Valor> buscarValoresPorEstacionamento(
			Estacionamento estacionamento) {
		TypedQuery<Valor> query = em.createQuery("from Valor", Valor.class);
		return query.getResultList();
	}

}
