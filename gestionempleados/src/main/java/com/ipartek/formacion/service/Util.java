package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public class Util {
	private Util() {
	}

	private static final int LONGITUD_DNI = 9;

	public static boolean validarDni(String dni) {
		boolean valido = false;
		dni = dni.toUpperCase();

		int nDni = Integer.parseInt(dni.substring(0, LONGITUD_DNI - 1));
		char lDni = dni.substring(dni.length() - 2, dni.length() - 1).charAt(0);
		if (calcularLetra(nDni) == lDni) {
			valido = true;
		}

		return valido;
	}

	private static char calcularLetra(int nDni) {
		char letra = 0;
		final char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
				'D', 'X', 'B', 'N', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K',
				'E', 'T' };
		letra = letras[nDni % letras.length];
		return letra;
	}

/*
	 public static Departamento parseTipoDepartamento(int codTipoDepartamento) {
		 Departamento departamento = null;
		 
		 
		 
		    TipoCurso tipo = TipoCurso.LANBIDE;
		    if (codTipo == TipoCurso.HOBETUZ.getCodigo()) {
		      tipo = TipoCurso.HOBETUZ;
		    } else {
		      if (codTipo == TipoCurso.FUNDACION_TRIPARTITA.getCodigo()) {
		        tipo = TipoCurso.FUNDACION_TRIPARTITA;
		      }
		    }

		    return departamento;
		  }

	public static Idioma parseIdioma(String idioma) {

		Idioma auxiliar = Idioma.CASTELLANO;
		int codigoIdioma = Integer.parseInt(idioma);
		if (codigoIdioma == Idioma.EUSKERA.getCodigo()) {
			auxiliar = Idioma.EUSKERA;
		} else {
			if (codigoIdioma == Idioma.INGLES.getCodigo()) {
				auxiliar = Idioma.INGLES;
			}
		}

		return auxiliar;
	}

	public static List<Idioma> parseIdioma(String[] idiomas) {
		List<Idioma> aux = null;
		aux = new ArrayList<Idioma>();
		for (String idioma2 : idiomas) {
			Idioma idioma = Idioma.CASTELLANO;
			int codigoIdioma = Integer.parseInt(idioma2);
			if (codigoIdioma == Idioma.EUSKERA.getCodigo()) {
				idioma = Idioma.EUSKERA;
			} else {
				if (codigoIdioma == Idioma.INGLES.getCodigo()) {
					idioma = Idioma.INGLES;
				}
			}
			aux.add(idioma);
		}
		return aux;
	}

	public static boolean tryParseInt(String cadena) {
		boolean exito = true;

		try {
			Integer.parseInt(cadena);
		} catch (NumberFormatException e) {
			exito = false;
		}
		return exito;
	}
*/
}
