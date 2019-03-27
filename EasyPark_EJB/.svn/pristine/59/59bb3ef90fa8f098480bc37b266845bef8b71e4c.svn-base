package br.com.easypark.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.EnderecoDAO;
import br.com.easypark.entity.EnderecoEstacionamento;
import br.com.easypark.entity.Estacionamento;

@Stateless
public class EnderecoDAOImpl extends DAOImpl<EnderecoEstacionamento, Long>
		implements EnderecoDAO {

	@Override
	public EnderecoEstacionamento buscarEnderecoPorEstacionamento(
			Estacionamento estacionamento) {
		TypedQuery<EnderecoEstacionamento> query = em
				.createQuery(
						"from EnderecoEstacionamento ee where ee.estacionamento.id = :idEstacionamento",
						EnderecoEstacionamento.class);
		query.setParameter("idEstacionamento", estacionamento.getId());
		System.out.println("Endereço: "
				+ estacionamento.getEnderecoEstacionamento().getCep());
		return query.getSingleResult();
	}

}
