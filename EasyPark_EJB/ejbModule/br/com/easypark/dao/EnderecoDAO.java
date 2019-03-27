package br.com.easypark.dao;

import javax.ejb.Local;

import br.com.easypark.entity.EnderecoEstacionamento;
import br.com.easypark.entity.Estacionamento;

@Local
public interface EnderecoDAO extends DAO<EnderecoEstacionamento, Long> {

	EnderecoEstacionamento buscarEnderecoPorEstacionamento(
			Estacionamento estacionamento);
}
