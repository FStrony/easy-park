package br.com.easypark.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.HorarioFuncionamento;

@Local
public interface HorarioDAO extends DAO<HorarioFuncionamento, Long> {

	List<HorarioFuncionamento> buscarHorariosPorEstacionamento(
			Estacionamento estacionamento);
}
