package br.com.easypark.utils;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * 
 *            Provides a common base class for all generated code behind files.
 */

public abstract class PageCodeBase {

	protected FacesContext facesContext;
	protected Map<String, Object> requestScope;
	protected Map<String, Object> sessionScope;
	protected Map<String, Object> applicationScope;
	protected Map<String, String> requestParam;

	public PageCodeBase() {

		facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		sessionScope = externalContext.getSessionMap();
		requestScope = externalContext.getRequestMap();
		applicationScope = externalContext.getApplicationMap();
		requestParam = externalContext.getRequestParameterMap();

	}

	public void addMsgError(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	public void addMsgSuccess(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	public Map<String, Object> getRequestScope() {
		return requestScope;
	}

	public void setRequestScope(Map<String, Object> requestScope) {
		this.requestScope = requestScope;
	}

	public Map<String, Object> getSessionScope() {
		return sessionScope;
	}

	public void setSessionScope(Map<String, Object> sessionScope) {
		this.sessionScope = sessionScope;
	}

	public Map<String, Object> getApplicationScope() {
		return applicationScope;
	}

	public void setApplicationScope(Map<String, Object> applicationScope) {
		this.applicationScope = applicationScope;
	}

	public Map<String, String> getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(Map<String, String> requestParam) {
		this.requestParam = requestParam;
	}

}
