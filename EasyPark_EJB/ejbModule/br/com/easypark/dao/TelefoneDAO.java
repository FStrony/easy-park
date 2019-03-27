package br.com.easypark.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.Telefone;

@Local
public interface TelefoneDAO extends DAO<Telefone, Long> {

	List<Telefone> buscarTelefonesPorEstacionamento(
			Estacionamento estacionamento);
	void removeTelefone(long telefone);
}
