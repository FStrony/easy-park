package br.com.easypark.converter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Esta classe tem por objetivo converter valores de string em real e objeto em
 * real
 * 
 * @author ExceptionIT
 * @since 30/05/2013
 * @version 1.0
 */

@FacesConverter(value = "realConveter")
public class ValorEmRealConverter implements Converter {

	/**
	 * O objetivo deste método é pegar a variável valorTela com o FacesContext e
	 * converter ela para o tipo real
	 * 
	 * @throws se
	 *             o valorTela for igual a nulo ou estiver em branco ele retorna
	 *             0.0
	 * @exception se
	 *                o valorTela não estiver igual ao estabelecido ele retorna
	 *                valor inválido
	 * @param valorTela
	 *            string que será convertida
	 * @param arg0
	 *            variável do FacesContext de auxilio
	 * @param arg1
	 *            variável do UIComponet de auxilio
	 * @return retorna a variável valorTela convertida em real
	 */

	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String valorTela) throws ConverterException {

		if (valorTela == null || valorTela.toString().trim().equals("")) {
			return 0.0d;

		} else {
			try {

				if (valorTela.contains(".")) {
					valorTela.length();
					char[] valor = valorTela.toCharArray();
					int indice1 = valorTela.length() - 3;
					Character x = valorTela.charAt(indice1);
					if (x.equals('.')) {
						valor[indice1] = ',';
					}
					int indice2 = valorTela.length() - 2;
					x = valorTela.charAt(indice2);
					if (x.equals('.')) {
						valor[indice1] = ',';
					}
					valorTela = new String(valor);
					if (valorTela.contains(",")) {
						valorTela = valorTela
								.replaceAll(Pattern.quote("."), "");
						String novoValor = valorTela.replace(",", ".");
						return new Double(novoValor);
					}
				}

			} catch (Exception e) {
				throw new ConverterException("Valor inválido");
			}

			try {
				valorTela = valorTela.replaceAll(Pattern.quote("."), "");
				String novoValor = valorTela.replace(",", ".");
				return new Double(novoValor);

			} catch (Exception e) {
				throw new ConverterException("Valor inválido");
			}
		}

	}

	/**
	 * O objetivo deste método é pegar a variável valorTela com o FacesContext e
	 * converter ela para o tipo real
	 * 
	 * @throws se
	 *             o valorTela for igual a nulo ou estiver em branco ele retorna
	 *             0.0
	 * @param valorTela
	 *            objeto que será convertida
	 * @param arg0
	 *            variável do FacesContext de auxilio
	 * @param arg1
	 *            variável do UIComponet de auxilio
	 * @return retorna a variável valorTela convertida em real
	 */

	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object valorTela) throws ConverterException {

		if (valorTela == null || valorTela.toString().trim().equals("")) {
			return "0,00";

		} else {
			NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
			nf.setMaximumFractionDigits(2);
			nf.setMinimumFractionDigits(2);
			return nf.format(Double.valueOf(valorTela.toString()));
		}
	}
}