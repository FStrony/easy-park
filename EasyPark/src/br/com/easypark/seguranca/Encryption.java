package br.com.easypark.seguranca;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Esta classe tem por objetivo criptografar a senha
 * 
 * @author ExceptionIT
 * @since 25/06/2013
 * @version 1.2
 */

public class Encryption {
	
	/**
	 * O objetivo deste metodo é gerar o valor criptografado
	 * @param valorCriptogragfado é a senha que foi criptografada
	 * @param senhaNum é a senha a ser criptografada
	 * @param zero é a variavel de auxilo para criptografar o valor
	 * @exception se ocorrer algum erro na hora de criptografar a senha retorna uma mensagem de erro
	 * @return o valor criptografado
	 */
	public String gerarCripto(String value) {

		String valorCriptogragfado = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(value.getBytes("ISO-8859-1"));

			BigInteger senhaNum = new BigInteger(1, md.digest());

			valorCriptogragfado = senhaNum.toString(16);

			String zero = "";

			if (valorCriptogragfado.length() < 32) {
				for (int i = 0; i < (32 - valorCriptogragfado.length()); i++) {
					zero += "0";
				}
				valorCriptogragfado = zero + valorCriptogragfado;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valorCriptogragfado;
	}
	
}
