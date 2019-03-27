package br.com.easypark.service.timer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.easypark.dao.EstacionamentoDAO;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.HorarioFuncionamento;

@Path("estacionamentoService")
@Stateless
public class JSONEstacionamentoService {

	@EJB
	private EstacionamentoDAO estacDAO;

	@Schedule(hour = "1", minute = "21", second = "20")
	@GET
	@Produces("application/json")
	public List<EstacionamentoVO> emiteNotificacao() {
		System.out
				.println("------------------- Gerou a rotina do dia e atualizou o arquivo json com os estacionamentos ------------------");
		List<Estacionamento> listaEstacionamento = estacDAO.buscarTodos();
		List<EstacionamentoVO> listaEstacVO = new ArrayList<EstacionamentoVO>();

		for (Estacionamento estacionamento : listaEstacionamento) {
			EstacionamentoVO estacVO = new EstacionamentoVO();
			estacVO.setLatitude(estacionamento.getEnderecoEstacionamento()
					.getLatitude());
			estacVO.setLongitude(estacionamento.getEnderecoEstacionamento()
					.getLongitude());
			DetalheEstacionamentoVO detalhe = new DetalheEstacionamentoVO();
			detalhe.setNome(estacionamento.getNome());
			System.out.println("EstacID: " + estacionamento.getId());
			Long qtdeVagas = estacDAO
					.getQuantidadeVagasCarroPorEstacionamento(estacionamento
							.getId());
			detalhe.setVagas(String.valueOf(qtdeVagas));
			HorarioEstacionamentoVO horarios = new HorarioEstacionamentoVO();
			List<HorarioFuncionamento> horariosFuncionamento = estacionamento
					.getHorariosFuncionamento();

			for (HorarioFuncionamento hf : horariosFuncionamento) {
				if (hf.getTipoDia().getDescricao().equalsIgnoreCase("feriado")) {
					horarios.setFeriado(hf.getHorarioFuncionamentoInicio()
							+ " - " + hf.getHorarioFuncionamentoFinal());
				} else if (hf.getTipoDia().getDescricao()
						.equalsIgnoreCase("util")) {
					horarios.setDiaUtil(hf.getHorarioFuncionamentoInicio()
							+ " - " + hf.getHorarioFuncionamentoFinal());
				} else if (hf.getTipoDia().getDescricao()
						.equalsIgnoreCase("fim de semana")) {
					horarios.setFinalSemana(hf.getHorarioFuncionamentoInicio()
							+ " - " + hf.getHorarioFuncionamentoFinal());
				}
			}
			if (horarios.getFeriado() == null) {
				horarios.setFeriado("Não Informado");
			} else if (horarios.getDiaUtil() == null) {
				horarios.setDiaUtil("Não Informado");
			} else if (horarios.getFinalSemana() == null) {
				horarios.setFinalSemana("Não Informado");
			}
			detalhe.setHorarios(horarios);
			PrecoEstacionamentoVO precos = new PrecoEstacionamentoVO();
			List<Object[]> objects = estacDAO
					.getValoresEstacionamento(estacionamento.getId());
			try {
				precos.setDiaria(String.valueOf(objects.get(0)[0]));
			} catch (IndexOutOfBoundsException ex) {
				precos.setDiaria("Não informado!");
			}
			try {
				precos.setFeriado(String.valueOf(objects.get(0)[1]));
			} catch (IndexOutOfBoundsException ex) {
				precos.setFeriado("Não informado!");
			}
			try {
				precos.setMensal(String.valueOf(objects.get(0)[2]));
			} catch (IndexOutOfBoundsException ex) {
				precos.setMensal("Não informado!");
			}
			BigDecimal valorHoraPorDiaUtilECarro = estacDAO
					.getValorHoraPorDiaUtilECarro(estacionamento.getId());
			if (valorHoraPorDiaUtilECarro == null) {
				precos.setHora("Valor não informado!");
			} else {
				precos.setHora(String
						.valueOf("R$ " + valorHoraPorDiaUtilECarro));
			}
			detalhe.setPrecos(precos);
			estacVO.setDetalhes(detalhe);
			listaEstacVO.add(estacVO);
		}

		return listaEstacVO;
	}
}
