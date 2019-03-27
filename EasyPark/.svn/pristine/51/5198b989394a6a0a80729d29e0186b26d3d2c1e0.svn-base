package br.com.easypark.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Esta classe tem por objetivo converter valores de string a objeto e de objeto
 * a string
 * 
 * @author ExceptionIT
 * @since 30/05/2013
 * @version 1.0
 */

@FacesConverter(value = "convertInput")
public class ConversoresInput implements Converter {

	/**
	 * O objetivo deste método é pegar a variável valor com o FacesContext e
	 * converter ela para um objeto
	 * 
	 * @param valor
	 *            string que será convertida
	 * @param arg0
	 *            variável do FacesContext de auxilio
	 * @param arg1
	 *            variável do UIComponet de auxilio
	 * @return retorna a variável valor convertida em objeto
	 */

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		if (valor != null || valor != "") {
			valor = valor.toString().replaceAll("[- /.]", "");
			valor = valor.toString().replaceAll("[-()]", "");
		}
		return valor;
	}

	/**
	 * O objetivo deste método é pegar a variavel valor com o FacesContext e
	 * converter ela para uma string
	 * 
	 * @param valor
	 *            objeto que será convertida
	 * @param arg0
	 *            variável do FacesContext de auxilio
	 * @param arg1
	 *            variável do UIComponet de auxilio
	 * @return retorna a variavel valor convertida em string
	 */

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		return valor.toString();
	}
}