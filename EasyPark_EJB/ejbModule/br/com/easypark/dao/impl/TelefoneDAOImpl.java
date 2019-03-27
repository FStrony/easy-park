package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.TelefoneDAO;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.Telefone;

@Stateless
public class TelefoneDAOImpl extends DAOImpl<Telefone, Long> implements
		TelefoneDAO {

	@Override
	public List<Telefone> buscarTelefonesPorEstacionamento(
			Estacionamento estacionamento) {
		TypedQuery<Telefone> query = em
				.createQuery(
						"from Telefone t where t.estacionamento.id = :idEstacionamento",
						Telefone.class);
		query.setParameter("idEstacionamento", estacionamento.getId());
		return query.getResultList();
	}

	@Override
	public void removeTelefone(long telefone) {
		 Query query = em.createQuery("DELETE FROM Telefone t WHERE t.id = :p");
		 int deletedCount = query.setParameter("p", telefone).executeUpdate();
	}

}
