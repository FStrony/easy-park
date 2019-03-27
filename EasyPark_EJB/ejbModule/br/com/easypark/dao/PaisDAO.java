package br.com.easypark.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.Pais;

@Local
public interface PaisDAO extends DAO<Pais, Long> {

	List<Pais> buscarTodos();

}
