package br.com.easypark.mb;

import java.io.Serializable;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Logger;

import br.com.easypark.dao.EmpresaDAO;
import br.com.easypark.dao.LoginDAO;
import br.com.easypark.entity.Empresa;
import br.com.easypark.seguranca.Encryption;
import br.com.easypark.utils.SendMail;

/**
 * Esta classe tem por objetivo realizar e validar o login
 * 
 * @author ExceptionIT
 * @since 15/04/2013
 * @version 1.3
 */

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(LoginBean.class.getName());

	private Empresa empresa = new Empresa();
	private boolean isErro = false;
	private String messageError = "";

	@EJB
	private LoginDAO loginDAO;

	@EJB
	private EmpresaDAO empresaDAO;

	/**
	 * O objetivo deste metodo � efetuar o login
	 * 
	 * @param pagina
	 *            variavel que recebe a pagina para a qual vai ser redirecionada
	 * @param encontrado
	 *            variavel que valida se foi encontrado o login(true) ou
	 *            n�o(false)
	 * @param empresa
	 *            variavel que contem as informa��es da empresa(cnpj, email,
	 *            senha)
	 * @param loginDAO
	 *            variavel do tipo LoginDAO usada para validar o email e a senha
	 * @exception se
	 *                o login for efetuado com sucesso ele aparece uma mensagem
	 *                e redireciona para a pagina de principal, caso contrario
	 *                exibe uma mensagem de erro e permanece na pagina de login
	 * @return retorna para a pagina que foi direcionado
	 */
	public String efetuaLogin() {
		String pagina = null;
		boolean encontrado = false;
		if (empresa != null) {
			empresa.setSenha(new Encryption().gerarCripto(empresa.getSenha()));
			encontrado = loginDAO.verificaEmailESenha(empresa.getEmail(),
					empresa.getSenha());
			if (encontrado == true) {
				pagina = "/xhtml/site/index?faces-redirect=true";
				logger.info("Efetuado o login!!");
				this.isErro = false;

			} else {
				messageError = "Usu�rio e/ou Senha Inv�lidos!";
				logger.info("Usuario/Senha Incorreta!!");
				this.isErro = true;
				this.empresa = new Empresa();

			}
		}

		return pagina;
	}

	private String randomPass(int lengthPass) {
		char[] chars = "AabBcCdefFghHiIjJkKlmnoOpqrstTGDXuvwWxyYzZ1234567890"
				.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < lengthPass; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	public String recoverPass() {
		if (this.empresa != null) {
			Empresa emp = empresaDAO.getEmpresa(empresa.getEmail());
			if (emp != null) {
				String criptoSenha = randomPass(12);
				emp.setSenha(new Encryption().gerarCripto(criptoSenha));
				empresaDAO.update(emp);
				SendMail send = new SendMail();
				send.sendMail(send.mailFrom, empresa.getEmail(), "Password",
						criptoSenha);
			}
		}
		return "/xhtml/site/index?faces-redirect=true";
	}

	/**
	 * @return retorna o email da empresa logada
	 */
	public boolean isLogado() {
		return empresa.getEmail() != null;
	}

	/**
	 * @return retorna para a pagina de login
	 */

	public String logout() {
		empresa = new Empresa();
		return "/xhtml/administracao/login?faces-redirect=true";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isErro() {
		return isErro;
	}

	public void setErro(boolean isErro) {
		this.isErro = isErro;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messaString) {
		this.messageError = messaString;
	}
}
