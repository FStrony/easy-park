package br.com.easypark.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.easypark.dao.EstacionamentoDAO;
import br.com.easypark.entity.Empresa;
import br.com.easypark.entity.EnderecoEstacionamento;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.service.timer.DetalheEstacionamentoVO;
import br.com.easypark.service.timer.EstacionamentoVO;
import br.com.easypark.service.timer.HorarioEstacionamentoVO;
import br.com.easypark.service.timer.PrecoEstacionamentoVO;

@Stateless
public class EstacionamentoDAOImpl extends DAOImpl<Estacionamento, Long>
		implements EstacionamentoDAO {

	@Override
	public List<Estacionamento> buscarTodos() {
		TypedQuery<Estacionamento> query = em.createQuery(
				"from Estacionamento", Estacionamento.class);
		return query.getResultList();
	}

	@Override
	public List<Estacionamento> buscarEstacionamentosPorEmpresa(Empresa empresa) {
		TypedQuery<Estacionamento> query = em.createQuery(
				"from Estacionamento est where est.empresa.email = :emp",
				Estacionamento.class);
		query.setParameter("emp", empresa.getEmail());
		return query.getResultList();
	}

	@Override
	public List<Estacionamento> buscarEstacionamento(String nome) {
		TypedQuery<Estacionamento> query = em.createQuery(
				"from Estacionamento est where est.nome like :nome",
				Estacionamento.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.setMaxResults(15).getResultList();
	}

	@Override
	public Estacionamento buscarEstacionamentoPorEndereco(
			EnderecoEstacionamento enderecoEstacionamento) {
		// TODO REALIZAR A LOGICA
		return null;
	}

	@Override
	public List<EstacionamentoVO> buscaTodosEstacionamentos() {
		String sql = "SELECT E.CD_ESTACIONAMENTO, E.DS_NOME, F.CD_HORARIOFUNC, TO_CHAR(F.DT_FUNCIONAMENTO_INICIO,'HH24:MI') ,"
				+ " TO_CHAR(F.DT_FUNCIONAMENTO_FINAL,'HH24:MI'), EE.LATITUDE, EE.LONGITUDE,"
				+ " EV.CD_VALOR, EV.VL_HORA, TD.DS_TIPO_DIA, EF.VL_DIARIA, EF.VL_MENSAL, EF.VL_SEMESTRAL, EV.CD_TIPO_VEICULO, TV.DS_TIPO_VEICULO"
				+ " FROM EP_ESTACIONAMENTO E, EP_FUNCIONAMENTO F , EP_ESTACIONAMENTO_VEICULO EF,"
				+ " EP_ESTAC_END EE, EP_VALOR EV, EP_TIPO_DIA TD, EP_TIPO_VEICULO TV"
				+ "	WHERE"
				+ " E.CD_ESTACIONAMENTO = EE.CD_ESTACIONAMENTO AND"
				+ " E.CD_ESTACIONAMENTO = F.CD_ESTACIONAMENTO AND"
				+ " E.CD_ESTACIONAMENTO = EF.CD_ESTACIONAMENTO AND"
				+ " E.CD_ESTACIONAMENTO = EV.CD_ESTACIONAMENTO AND"
				+ " EV.CD_TIPO_VEICULO = TV.CD_TIPO_VEICULO AND"
				+ " TD.CD_TIPO_DIA = 3 AND" + " F.CD_TIPO_DIA = 3";
		Query query = em.createNativeQuery(sql);
		List<Object[]> resultList = query.getResultList();

		List<EstacionamentoVO> listaEstacionamentoVO = new ArrayList<EstacionamentoVO>();

		for (int i = 0; i < resultList.size(); i++) {
			EstacionamentoVO estacionamento = new EstacionamentoVO();
			estacionamento.setLatitude(resultList.get(i)[5].toString());
			estacionamento.setLongitude(resultList.get(i)[6].toString());

			DetalheEstacionamentoVO detalheHorarioFuncionamentoVO = new DetalheEstacionamentoVO();
			detalheHorarioFuncionamentoVO.setNome(resultList.get(i)[1]
					.toString());

			PrecoEstacionamentoVO precoEstacionamentoVO = new PrecoEstacionamentoVO();
			precoEstacionamentoVO.setDiaria(resultList.get(i)[10].toString());
			// precoEstacionamentoVO.setHora(resultList.get(i)[8].toString());
			// precoEstacionamentoVO.setMensal(resultList.get(i)[11].toString());

			detalheHorarioFuncionamentoVO.setPrecos(precoEstacionamentoVO);
			// detalheHorarioFuncionamentoVO.setVagas(vagas);

			HorarioEstacionamentoVO horarioEstacionamentoVO = new HorarioEstacionamentoVO();
			// horarioEstacionamentoVO.setDiaUtil(diaUtil);
			// horarioEstacionamentoVO.setFeriado(feriado);
			// horarioEstacionamentoVO.setFinalSemana(finalSemana);
			detalheHorarioFuncionamentoVO.setHorarios(horarioEstacionamentoVO);

			estacionamento.setDetalhes(detalheHorarioFuncionamentoVO);
			listaEstacionamentoVO.add(estacionamento);
		}

		return listaEstacionamentoVO;
	}

	@Override
	public Long getQuantidadeVagasCarroPorEstacionamento(Long idEstacionamento) {
		TypedQuery<Long> query = em
				.createQuery(
						"select sum(ev.quantidadeVagas) from EstacionamentoVeiculo ev where ev.estacionamento.id = :cdEstac",
						Long.class);
		query.setParameter("cdEstac", idEstacionamento);
		return query.getSingleResult();
	}

	@Override
	public List<Object[]> getValoresEstacionamento(Long idEstacionamento) {
		Query query = em
				.createQuery("select ev.diaria, ev.mensal, ev.semestral from EstacionamentoVeiculo ev where ev.tipoVeiculo.id = 3 and ev.estacionamento.id = :cdEstac");
		query.setParameter("cdEstac", idEstacionamento);
		List<Object[]> object = query.getResultList();
		return object;
	}

	@Override
	public BigDecimal getValorHoraPorDiaUtilECarro(Long idEstacionamento) {
		TypedQuery<BigDecimal> query = em
				.createQuery(
						"select v.hora from Valor v where v.tipoDia.id = 3 and v.tipoVeiculo.id = 3 and v.estacionamento.id = :cdEstac",
						BigDecimal.class);
		query.setParameter("cdEstac", idEstacionamento);
		BigDecimal valorHora = query.getSingleResult();
		return valorHora;
	}

}
