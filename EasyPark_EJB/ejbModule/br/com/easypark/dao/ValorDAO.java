package br.com.easypark.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.Valor;

@Local
public interface ValorDAO {

	List<Valor> buscarValoresPorEstacionamento(Estacionamento estacionamento);
}
