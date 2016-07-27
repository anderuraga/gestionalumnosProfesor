package org.formacion.ipartek.gestionempleados.service;

/**
 * 
 * Clase java encargada de la comprobación de los datos de entrada. Comprobación
 * de DNI, numeros Cp y datos CC y NSS que recibimos de los JSP.
 * 
 * @author Josu
 *
 */
public class Util {

	String dni;

	/**
	 * comprueba el DNI
	 * 
	 * @param dni
	 * @return
	 */
	public static boolean validarDni(String dni) {
		/**
		 * Método que comprueba si el DNI introducido en el formulario es
		 * correcto.
		 * 
		 */
		boolean bool = false;
		dni = dni.toUpperCase();
		int numero = 0;
		int resto = 0;
		// comprobar validez Dni
		char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		numero = Integer.parseInt(dni.substring(0, dni.length() - 1));
		resto = numero % 23;
		if (letraDni[resto] == dni.substring(dni.length() - 1).charAt(0)) {
			bool = true;
		}

		return bool;
	}

	/**
	 * comprobar el CP tengo 5 digitos
	 * 
	 * @param cp
	 * @return
	 */
	public static boolean validarCP(int cp) {
		boolean bool = false;
		if (10000 < cp && cp < 99999) {
			bool = true;
		}
		return bool;
	}

	/**
	 * 
	 * intentamos validar el numero SS
	 * 
	 * @param NSS
	 * @return
	 */
	public static boolean validarNSS(long NSS) {
		boolean bool = false;
		// if (100000000000 < NSS && NSS < 999999999999) {
		bool = true;
		// }
		return bool;

	}

	/**
	 * pasar el string recibido del formulario a int
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean tryParseInt(String cadena) {
		boolean exito = true;
		int numero;
		try {
			numero = Integer.parseInt(cadena);
		} catch (NumberFormatException e) {
			exito = false;
		}
		return exito;
	}

}
