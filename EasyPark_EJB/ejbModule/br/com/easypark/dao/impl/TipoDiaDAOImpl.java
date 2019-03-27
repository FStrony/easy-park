package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.TipoDiaDAO;
import br.com.easypark.entity.TipoDia;

@Stateless
public class TipoDiaDAOImpl extends DAOImpl<TipoDia, Long> implements
		TipoDiaDAO {

	@PersistenceContext(unitName = "CLIENTE_ORACLE")
	private EntityManager em;

	@Override
	public List<TipoDia> buscarTodos() {
		TypedQuery<TipoDia> query = em.createQuery("from TipoDia",
				TipoDia.class);
		return query.getResultList();
	}

}
