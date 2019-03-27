package br.com.easypark.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.EmpresaDAO;
import br.com.easypark.entity.Empresa;

@Stateless
public class EmpresaDAOImpl extends DAOImpl<Empresa, Long> implements
		EmpresaDAO {

	@Override
	public List<Empresa> buscarTodos() {
		TypedQuery<Empresa> query = em.createQuery("from Empresa",
				Empresa.class);
		return query.getResultList();
	}

	@Override
	public Empresa getEmpresa(String email) {
		TypedQuery<Empresa> query = em.createQuery(
				"from Empresa where email = :mail", Empresa.class);
		query.setParameter("mail", email);
		return query.getSingleResult();
	}

}
