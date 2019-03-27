package br.com.easypark.mb;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import br.com.easypark.dao.EmpresaDAO;
import br.com.easypark.entity.Empresa;
import br.com.easypark.seguranca.Encryption;

/**
 * Esta classe tem por objetivo inserir, atualizar ou carregar o perfil da
 * empresa
 * 
 * @author ExceptionIT
 * @since 16/07/2013
 * @version 2.3
 */

@ManagedBean
@SessionScoped
public class EmpresaBean {

	private static Logger logger = Logger
			.getLogger(EmpresaBean.class.getName());

	private Empresa empresa = new Empresa();
	
	private String senhaAntiga = "";
	private String senha = "";
	private String confirmeSenha = "";
	

	@EJB
	private EmpresaDAO empresaDAO;

	/**
	 * O objetivo deste método e inserir uma empresa com email, cnpj e senha
	 * 
	 * @param msg
	 *            variavel de mensagem
	 * @param pagina
	 *            variavel que fica a pagina de retorno
	 * @param empresa
	 *            variavel do tipo Empresa que possui os valores da Empresa
	 * @param empresaDAO
	 *            variavel do tipo EmpresaDAO que lista a empresa e pega o seu
	 *            email
	 * @exception se
	 *                a empresa for igual a nulo retorna um erro e uma mensagem
	 * @return O método retornara para a pagina de login
	 */

	public String inserir() {
		FacesMessage msg = null;
		String pagina = "";
		if (empresa != null) {
			empresa.setSenha(new Encryption().gerarCripto(empresa.getSenha()));
			empresaDAO.insert(this.empresa);
			msg = new FacesMessage("Sucesso", "Cliente cadastrado com sucesso");
			logger.info("Empresa com email: " + empresa.getEmail()
					+ " cadastrada com sucesso!");
			pagina = "/xhtml/administracao/login.xhtml";
			this.empresa = new Empresa();
		} else {
			msg = new FacesMessage("Erro", "Problemas ao cadastrar a empresa");
			logger.error("Problemas ao cadastrar a Empresa");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return pagina;
	}

	/**
	 * O objetivo deste método e atualizar uma empresa com email, cnpj
	 * 
	 * @param msg
	 *            variavel de mensagem
	 * @param pagina
	 *            variavel que fica a pagina de retorno
	 * @param empresa
	 *            variavel do tipo Empresa que possui os valores da Empresa
	 * @param empresaDAO
	 *            variavel do tipo EmpresaDAO que lista a empresa e pega o seu
	 *            email
	 * @exception se
	 *                a empresa for igual a nulo retorna um erro e uma mensagem
	 * @return O método retornara para a página de login
	 */

	public String atualizar() {
		FacesMessage msg = null;
		String pagina = "";
		if (empresa != null) {
			empresa.setSenha(new Encryption().gerarCripto(empresa.getSenha()));
			empresaDAO.update(this.empresa);
			msg = new FacesMessage("Sucesso", "Empresa atualizada com sucesso");
			logger.info("Empresa com email: " + empresa.getEmail()
					+ " atualizada com sucesso!");
			pagina = "/xhtml/site/index.xhtml";

			FacesContext fc = FacesContext.getCurrentInstance();

			LoginBean login = (LoginBean) fc.getExternalContext()
					.getSessionMap().get("loginBean");

			Empresa emp = login.getEmpresa();

			emp.setEmail(empresa.getEmail());

			login.setEmpresa(emp);

		} else {
			msg = new FacesMessage("Erro", "Problemas ao atualizar a empresa");
			logger.error("Problemas ao atualizar a Empresa");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return pagina;
	}

	
	public String redirectAlterPass(){
		return "/xhtml/administracao/empresa/estacionamento/senhaEmpresa.xhtml";
	}
	
	public String alterPass(){
		FacesMessage msg = null;
		String redirect = "/xhtml/administracao/empresa/estacionamento/perfilEmpresa.xhtml";
		Encryption cripto = new Encryption();
		if(empresa != null){
			if(cripto.gerarCripto(senhaAntiga).equals(empresa.getSenha())){
				if(senha.equals(confirmeSenha)){
					empresa.setSenha(cripto.gerarCripto(senha));
					empresaDAO.update(empresa);
					msg = new FacesMessage("Sucesso", "Empresa atualizada com sucesso");
				}else {
					msg = new FacesMessage("Erro", "Senhas diferentes");
					logger.error("Problemas ao atualizar a Empresa");
					redirect = "/xhtml/administracao/empresa/estacionamento/senhaEmpresa.xhtml";
				}
			}else {
				msg = new FacesMessage("Erro", "Senha incorreta");
				logger.error("Problemas ao atualizar a Empresa");
				redirect = "/xhtml/administracao/empresa/estacionamento/senhaEmpresa.xhtml";
			}
		}else {
			msg = new FacesMessage("Erro", "Problemas ao atualizar a empresa");
			logger.error("Problemas ao atualizar a Empresa");
			redirect = "/xhtml/administracao/empresa/estacionamento/senhaEmpresa.xhtml";
		}
		this.senha = "";
		this.senhaAntiga = "";
		this.confirmeSenha = "";
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return redirect;
	}
	
	
	/**
	 * O objetivo deste metodo e carregar o perfil da empresa com email
	 * 
	 * @param empresa
	 *            variavel que recebe o email da empresa logada
	 * @return O metodo retornara para a pagina perfilEmpresa
	 */

	public String carregaPerfilEmpresa(String email) {

		empresa = empresaDAO.getEmpresa(email);
		return "/xhtml/administracao/empresa/estacionamento/perfilEmpresa.xhtml";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getSenhaAntiga() {
		return senhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga = senhaAntiga;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmeSenha() {
		return confirmeSenha;
	}

	public void setConfirmeSenha(String confirmeSenha) {
		this.confirmeSenha = confirmeSenha;
	}
	
	

}
