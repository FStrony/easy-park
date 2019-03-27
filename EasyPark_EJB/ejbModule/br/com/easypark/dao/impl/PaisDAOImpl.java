package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.PaisDAO;
import br.com.easypark.entity.Pais;

@Stateless
public class PaisDAOImpl extends DAOImpl<Pais, Long> implements PaisDAO {

	@PersistenceContext(unitName = "CLIENTE_ORACLE")
	private EntityManager em;

	@Override
	public List<Pais> buscarTodos() {
		TypedQuery<Pais> query = em.createQuery("from Pais", Pais.class);
		return query.getResultList();
	}

}
