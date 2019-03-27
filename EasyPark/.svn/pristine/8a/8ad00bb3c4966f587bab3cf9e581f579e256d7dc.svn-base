package br.com.easypark.mb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;

import br.com.easypark.dao.EnderecoDAO;
import br.com.easypark.dao.EstacionamentoDAO;
import br.com.easypark.entity.EnderecoEstacionamento;
import br.com.easypark.entity.Estacionamento;


/**
 * Esta classe tem por objetivo buscar os estacionamentos 
 * @author ExceptionIT
 * @since 25/06/2013
 * @version 1.2
 */

@ManagedBean
@ViewScoped
public class FiltroEstacionamentoBean {

	private static final Logger LOGGER = Logger
			.getLogger(FiltroEstacionamentoBean.class.getName());

	@EJB
	private EstacionamentoDAO estacDAO;
	@EJB
	private EnderecoDAO enderecoDAO;

	private List<Estacionamento> todosEstacionamentos;

	private List<String> listaLatitude;

	private List<String> listaLongitude;

	private String latitude;

	private String longitude;

	/**
	 * O objetivo deste metodo e buscar estacionamentos
	 * @param todosEstacionamentos uma lista com todos os estacionamentos
	 * @param estacDAO variavel do tipo EstacionamentoDAO que e usada para realizar consultas
	 * @param eatacionamento variavel do tipo Estacionamento com as informaçoes do estacionamento
	 * @param enderecoEstacionamento variavel que recebe o endereco do estacionemento que esta sendo buscado
	 * @param listaLatitude lista das latitudes
	 * @param listaLongitude lista das longitudes
	 */
	
	public void buscarEstacionamentos() {
		LOGGER.info("Entrou no metodo");
		todosEstacionamentos = estacDAO.buscarTodos();
		for (Estacionamento estacionamento : todosEstacionamentos) {
			EnderecoEstacionamento enderecoEstacionamento = enderecoDAO
					.buscarEnderecoPorEstacionamento(estacionamento);
			estacionamento.setEnderecoEstacionamento(enderecoEstacionamento);

		}
		latitude = todosEstacionamentos.get(0).getEnderecoEstacionamento()
				.getLatitude();
		longitude = todosEstacionamentos.get(0).getEnderecoEstacionamento()
				.getLongitude();
		listaLatitude = new ArrayList<String>();
		listaLongitude = new ArrayList<String>();
		for (Estacionamento e : todosEstacionamentos) {
			listaLatitude.add(e.getEnderecoEstacionamento().getLatitude());
			listaLongitude.add(e.getEnderecoEstacionamento().getLongitude());
		}

		LOGGER.info("Estacionamento: " + todosEstacionamentos.get(0).getNome()
				+ " Latitude : " + latitude + " Longitude : " + longitude);
	}

	public List<Estacionamento> getBuscarTodos() {
		return todosEstacionamentos;
	}

	public void setBuscarTodos(List<Estacionamento> buscarTodos) {
		this.todosEstacionamentos = buscarTodos;
	}

	public List<Estacionamento> getTodosEstacionamentos() {
		return todosEstacionamentos;
	}

	public void setTodosEstacionamentos(
			List<Estacionamento> todosEstacionamentos) {
		this.todosEstacionamentos = todosEstacionamentos;
	}

	public List<String> getListaLatitude() {
		return listaLatitude;
	}

	public void setListaLatitude(List<String> listaLatitude) {
		this.listaLatitude = listaLatitude;
	}

	public List<String> getListaLongitude() {
		return listaLongitude;
	}

	public void setListaLongitude(List<String> listaLongitude) {
		this.listaLongitude = listaLongitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
