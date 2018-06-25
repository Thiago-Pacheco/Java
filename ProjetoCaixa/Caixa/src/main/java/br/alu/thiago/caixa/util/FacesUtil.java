package br.alu.thiago.caixa.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void adicionarMsgInfo(String msg) {

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, facesMessage);
	}

	public static void adicionarMsgError(String msg) {

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, facesMessage);
	}

	public static String obterParametro(String nome) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();

		Map<String, String> parametros = externalContext.getRequestParameterMap();
		
		String valor = parametros.get(nome);
		
		return valor;

	}
}
