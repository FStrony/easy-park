package br.com.easypark.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.easypark.dao.EnderecoDAO;
import br.com.easypark.dao.EstacionamentoDAO;
import br.com.easypark.dao.HorarioDAO;
import br.com.easypark.dao.ValorDAO;
import br.com.easypark.entity.Estacionamento;
import br.com.easypark.entity.Telefone;
import br.com.easypark.utils.CepWebService;

@ManagedBean
public class ListaEstacionamentoBean implements Serializable {

	/**
	 * Esta classe tem por objetivo buscar e listar estacionamentos por empresa
	 * empresa
	 * 
	 * @author ExceptionIT
	 * @since 16/07/2013
	 * @version 2.3
	 */

	private static final long serialVersionUID = 1L;

	private List<Estacionamento> listaEstacionamento;

	private List<Estacionamento> selectedListaEstacionamentos;

	private List<Telefone> listaTelefones;

	private Estacionamento selectedEstacionamento;

	private boolean showDetail = false;

	private String tipoLogradouro;
	private String logradouro;
	private String estado;
	private String cidade;
	private String bairro;

	@EJB
	private EstacionamentoDAO estacDAO;

	@EJB
	private HorarioDAO horarioDAO;

	@EJB
	private ValorDAO valorDAO;

	@EJB
	private EnderecoDAO enderecoDAO;

	/**
	 * O objetivo deste metodo e buscar o estacionamento atraves da empresa logada
	 */
	@PostConstruct
	public void inicializar() {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(true);
		LoginBean loginBean = (LoginBean) session.getAttribute("loginBean");
		listaEstacionamento = estacDAO
				.buscarEstacionamentosPorEmpresa(loginBean.getEmpresa());

	}

	public Estacionamento getSelectedEstacionamento() {
		return selectedEstacionamento;
	}

	public List<Estacionamento> getSelectedListaEstacionamentos() {
		return selectedListaEstacionamentos;
	}

	/**
	 * O objetivo deste metodo e carregar os detalhes do estacionamento
	 * @param estacionamento variavel do tipo Estacionamento que contem as informacoes do estacionamento
	 * @param selectedEstacionamento variavel recebe as informacoes do estacionamento buscado
	 * @param cepWebService variavel que recebe o o cep do estacionamento
	 * @exception se o resultado do cepWebService for igual a um ele preenche com as informacoes do estacionamento buscado, caso contrario retorna uma menssagem de erro
	 */
	
	public void mostrarDetalhes(Estacionamento estacionamento) {
		// FacesMessage msg = new FacesMessage("Estacionamento Selected",
		// ((Estacionamento) event.getObject()).getEmail());
		selectedEstacionamento = estacionamento;
		selectedEstacionamento.setHorariosFuncionamento(horarioDAO
				.buscarHorariosPorEstacionamento(selectedEstacionamento));
		selectedEstacionamento.setEnderecoEstacionamento(enderecoDAO
				.buscarEnderecoPorEstacionamento(estacionamento));
		// selectedEstacionamento.setValores(valorDAO.buscarValoresPorEstacionamento(selectedEstacionamento));
		showDetail = true;
//		CepWebService cepWebService = new CepWebService(selectedEstacionamento
//				.getEnderecoEstacionamento().getCep().toString());
//
//		if (cepWebService.getResultado() == 1) {
//			setTipoLogradouro(cepWebService.getTipoLogradouro());
//			setLogradouro(cepWebService.getLogradouro());
//			setEstado(cepWebService.getEstado());
//			setCidade(cepWebService.getCidade());
//			setBairro(cepWebService.getBairro());
//		} else {
//
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Servidor não está respondendo",
//							"Servidor não está respondendo"));
//		}
	}

	public List<Estacionamento> getListaEstacionamento() {
		return this.listaEstacionamento;
	}

	public void setListaEstacionamento(List<Estacionamento> listaEstacionamento) {
		this.listaEstacionamento = listaEstacionamento;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public boolean isShowDetail() {
		return showDetail;
	}

	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}

}
