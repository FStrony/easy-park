package br.com.easypark.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.TipoVeiculo;

@Local
public interface TipoVeiculoDAO extends DAO<TipoVeiculo, Long> {

	List<TipoVeiculo> buscarTodos();

}
