package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.TipoTelefoneDAO;
import br.com.easypark.entity.TipoTelefone;

@Stateless
public class TipoTelefoneDAOImpl extends DAOImpl<TipoTelefone, Long> implements
		TipoTelefoneDAO {

	@PersistenceContext(unitName = "CLIENTE_ORACLE")
	private EntityManager em;

	@Override
	public List<TipoTelefone> buscarTodos() {
		TypedQuery<TipoTelefone> query = em.createQuery("from TipoTelefone",
				TipoTelefone.class);
		return query.getResultList();
	}

}
