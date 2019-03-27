package br.com.easypark.mb;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.easypark.dao.EmpresaDAO;
import br.com.easypark.dao.EstacionamentoDAO;
import br.com.easypark.dao.PaisDAO;
import br.com.easypark.dao.TipoDiaDAO;
import br.com.easypark.dao.TipoTelefoneDAO;
import br.com.easypark.dao.TipoVeiculoDAO;
import br.com.easypark.entity.Empresa;
import br.com.easypark.entity.EnderecoEstacionamento;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.EstacionamentoVeiculo;
import br.com.easypark.entity.HorarioFuncionamento;
import br.com.easypark.entity.Pais;
import br.com.easypark.entity.Telefone;
import br.com.easypark.entity.TipoDia;
import br.com.easypark.entity.TipoTelefone;
import br.com.easypark.entity.TipoVeiculo;
import br.com.easypark.entity.Valor;

@ManagedBean
public class GeraBancoBean {

	@EJB
	private PaisDAO paisDAO;
	@EJB
	private EstacionamentoDAO estacionamentoDAO;

	@EJB
	private TipoTelefoneDAO tipoTelefoneDAO;

	@EJB
	private TipoDiaDAO tipoDiaDAO;

	@EJB
	private TipoVeiculoDAO tipoVeiculoDAO;

	@EJB
	private EmpresaDAO empresaDAO;

	@EJB
	private EstacionamentoDAO estacDAO;

	public void geraBanco() {
		Pais pais = new Pais();
		pais.setNome("Brasil");
		paisDAO.insert(pais);

		TipoDia tipoDia = new TipoDia();

		tipoDia.setDescricao("Feriado");
		tipoDiaDAO.insert(tipoDia);

		tipoDia = new TipoDia();

		tipoDia.setDescricao("Fim de Semana");
		tipoDiaDAO.insert(tipoDia);

		tipoDia = new TipoDia();

		tipoDia.setDescricao("Util");
		tipoDiaDAO.insert(tipoDia);

		TipoTelefone tipoTelefone = new TipoTelefone();
		tipoTelefone.setDescricao("Celular");
		tipoTelefoneDAO.insert(tipoTelefone);

		tipoTelefone = new TipoTelefone();
		tipoTelefone.setDescricao("Residencial");
		tipoTelefoneDAO.insert(tipoTelefone);

		tipoTelefone = new TipoTelefone();
		tipoTelefone.setDescricao("Comercial");
		tipoTelefoneDAO.insert(tipoTelefone);

		TipoVeiculo tipoVeiculo = new TipoVeiculo();
		tipoVeiculo.setDescricao("Caminh�o");
		tipoVeiculoDAO.insert(tipoVeiculo);

		tipoVeiculo = new TipoVeiculo();
		tipoVeiculo.setDescricao("Moto");
		tipoVeiculoDAO.insert(tipoVeiculo);

		tipoVeiculo = new TipoVeiculo();
		tipoVeiculo.setDescricao("Carro");
		tipoVeiculoDAO.insert(tipoVeiculo);

		Empresa empresa = new Empresa();
		empresa.setCnpj(25564212554L);
		empresa.setEmail("empresa@empresa.com");
		empresa.setSenha("empresa");
		empresaDAO.insert(empresa);

		Estacionamento estacionamento = new Estacionamento();
		estacionamento.setEmail("estacionamento@estacionamento.com");

		Empresa empresa1 = empresaDAO.searchByID(1L);
		estacionamento.setEmpresa(empresa1);

		EnderecoEstacionamento enderecoEstacionamento = new EnderecoEstacionamento();
		enderecoEstacionamento.setCep("05749-300");
		enderecoEstacionamento.setComplemento("Proximos ao posto de gasolina");

		enderecoEstacionamento.setEstacionamento(estacionamento);
		enderecoEstacionamento.setLatitude("-23.585837027923144");
		enderecoEstacionamento.setLongitude("-46.6340076006985");
		enderecoEstacionamento.setLogradouro("Rua José Maria pinto zilli, 119");
		enderecoEstacionamento.setNumero(119);
		Pais pais1 = paisDAO.searchByID(1L);
		enderecoEstacionamento.setPais(pais1);

		estacionamento.setEnderecoEstacionamento(enderecoEstacionamento);

		HorarioFuncionamento horarioFuncionamento1 = new HorarioFuncionamento();
		horarioFuncionamento1.setHorarioFuncionamentoFinal("20:10");
		horarioFuncionamento1.setHorarioFuncionamentoInicio("9:00");
		TipoDia tipoDia1 = tipoDiaDAO.searchByID(3L);
		horarioFuncionamento1.setTipoDia(tipoDia1);

		HorarioFuncionamento horarioFuncionamento2 = new HorarioFuncionamento();

		horarioFuncionamento2.setHorarioFuncionamentoFinal("18:10");
		horarioFuncionamento2.setHorarioFuncionamentoInicio("9:00");
		TipoDia tipoDia2 = tipoDiaDAO.searchByID(2L);
		horarioFuncionamento2.setTipoDia(tipoDia2);

		estacionamento.addHorarioFuncionamento(horarioFuncionamento1);
		estacionamento.addHorarioFuncionamento(horarioFuncionamento2);

		EstacionamentoVeiculo estacionamentoVeiculo = new EstacionamentoVeiculo();
		estacionamentoVeiculo.setDiaria(new BigDecimal("18"));
		estacionamentoVeiculo.setMensal(new BigDecimal("170"));
		estacionamentoVeiculo.setQuantidadeVagas(12);
		estacionamentoVeiculo.setSemestral(new BigDecimal("560"));
		estacionamentoVeiculo.setEstacionamento(estacionamento);
		TipoVeiculo tipoVeiculo1 = tipoVeiculoDAO.searchByID(1L);
		estacionamentoVeiculo.setTipoVeiculo(tipoVeiculo1);

		estacionamento.addEstacionamentoVeiculo(estacionamentoVeiculo);

		estacionamento.setIsSeguro(true);
		estacionamento.setNome("Royal Park");
		estacionamento.setSite("www.royalpark.com.br");

		Telefone telefone1 = new Telefone();
		telefone1.setDdd(11);
		telefone1.setNumero(982944788L);
		TipoTelefone tipoTelefone1 = tipoTelefoneDAO.searchByID(1L);
		telefone1.setTipoTelefone(tipoTelefone1);

		Telefone telefone2 = new Telefone();
		telefone2.setDdd(11);
		telefone2.setNumero(982944788L);
		TipoTelefone tipoTelefone2 = tipoTelefoneDAO.searchByID(2L);
		telefone2.setTipoTelefone(tipoTelefone2);

		estacionamento.addTelefoneEstacionamento(telefone1);
		estacionamento.addTelefoneEstacionamento(telefone2);

		Valor valor1 = new Valor();
		valor1.setEstacionamento(estacionamento);
		valor1.setHora(new BigDecimal("2"));
		TipoVeiculo tipoVeiculoCarro = tipoVeiculoDAO.searchByID(3L);
		TipoDia tipoDiaUtil = tipoDiaDAO.searchByID(3L);
		valor1.setTipoDia(tipoDiaUtil);
		valor1.setTipoVeiculo(tipoVeiculoCarro);

		Valor valor2 = new Valor();
		valor2.setEstacionamento(estacionamento);
		valor2.setHora(new BigDecimal("4"));
		TipoDia tipoDiaFinalSemana = tipoDiaDAO.searchByID(2L);
		valor2.setTipoDia(tipoDiaFinalSemana);
		valor2.setTipoVeiculo(tipoVeiculoCarro);

		Valor valor3 = new Valor();
		valor3.setEstacionamento(estacionamento);
		valor3.setHora(new BigDecimal("6"));
		valor3.setTipoDia(tipoDiaUtil);
		TipoVeiculo tipoVeiculoCaminhao = tipoVeiculoDAO.searchByID(1L);
		valor3.setTipoVeiculo(tipoVeiculoCaminhao);

		estacionamento.addValorHoraEstacionamento(valor1);
		estacionamento.addValorHoraEstacionamento(valor2);
		estacionamento.addValorHoraEstacionamento(valor3);

		estacDAO.insert(estacionamento);

	}

}
