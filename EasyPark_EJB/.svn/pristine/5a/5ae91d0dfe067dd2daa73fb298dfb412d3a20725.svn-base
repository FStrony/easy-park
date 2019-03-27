package br.com.easypark.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.Empresa;

@Local
public interface EmpresaDAO extends DAO<Empresa, Long> {

	List<Empresa> buscarTodos();

	Empresa getEmpresa(String email);

}
