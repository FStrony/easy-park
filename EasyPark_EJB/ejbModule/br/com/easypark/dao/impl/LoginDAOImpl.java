package br.com.easypark.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.LoginDAO;
import br.com.easypark.entity.Empresa;

@Stateless
public class LoginDAOImpl implements LoginDAO {

	@PersistenceContext(unitName = "CLIENTE_ORACLE")
	private EntityManager em;

	@Override
	public boolean verificaEmailESenha(String email, String senha) {
		TypedQuery<Empresa> query = em.createQuery(
				"from Empresa e where e.email = :em and e.senha = :senha",
				Empresa.class);
		query.setParameter("em", email);
		query.setParameter("senha", senha);
		boolean encontrado = !query.getResultList().isEmpty();
		return encontrado;
	}

}
