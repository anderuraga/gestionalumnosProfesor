package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.AlumnoDAOImp;
import com.ipartek.formacion.pojo.DuracionModulo;
import com.ipartek.formacion.pojo.Genero;
import com.ipartek.formacion.pojo.Idioma;
import com.ipartek.formacion.pojo.TipoCurso;

public class Util {
  private static final Logger LOG=Logger.getLogger(Util.class);
	private static final int LONGITUD_DNI = 9;
	public static boolean validarDni(String dni){
		boolean valido = false;
		dni = dni.toUpperCase();

		int nDni = Integer.parseInt(dni.substring(0, LONGITUD_DNI-1));
		char lDni = dni.substring(dni.length()-2, dni.length()-1).charAt(0);
		if(calcularLetra(nDni)==lDni){
			valido = true;
		}

		return valido;
	}
	private static char calcularLetra(int nDni){
		char letra = 0;
		final char [] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};
		letra = letras[nDni % letras.length];
		return letra;
	}
	public static Genero parseGenero(String genero){
		Genero aux = Genero.MASCULINO;

		int codigo = Integer.parseInt(genero);

		if(codigo== Genero.FEMENINO.getCodigo()){
			aux = Genero.FEMENINO;
		}else{
		  if(codigo== Genero.OTROS.getCodigo()){
		    aux = Genero.OTROS;
		  }
		}
		return aux;
	}

	public static DuracionModulo parseDuracion(String duracion){
		DuracionModulo d = DuracionModulo.HORAS15;
		int codigo = Integer.parseInt(duracion);

		if(codigo==DuracionModulo.HORAS20.getCodigo()){
			d = DuracionModulo.HORAS20;
		}else{
			if(codigo== DuracionModulo.HORAS45.getCodigo()){
				d = DuracionModulo.HORAS45;
			}else{
				if(codigo== DuracionModulo.HORAS80.getCodigo()){
					d = DuracionModulo.HORAS80;
				}else{
					if(codigo== DuracionModulo.HORAS90.getCodigo()){
						d = DuracionModulo.HORAS90;
					}

				}
			}
		}

		return d;
	}
	public static TipoCurso parseTipoCurso(String codigo){
		TipoCurso tipo = TipoCurso.LANBIDE;
		int cod = Integer.parseInt(codigo);
		if(TipoCurso.FUNDACION_TRIPARTITA.getCodigo()==cod){
			tipo = TipoCurso.FUNDACION_TRIPARTITA;
		}else {
			if(TipoCurso.HOBETUZ.getCodigo()==cod){
				tipo = TipoCurso.HOBETUZ;
			}
		}


		return tipo;
	}
	public static Idioma parseIdioma(String idioma){
			
		Idioma aux = Idioma.CASTELLANO;
		int codigoIdioma = Integer.parseInt(idioma);
		if(codigoIdioma == Idioma.EUSKERA.getCodigo()){
			aux = Idioma.EUSKERA;
		}else{
			if(codigoIdioma==Idioma.INGLES.getCodigo()){
				aux = Idioma.INGLES;
			}
		}
		
		return aux;
	}
	public static List<Idioma> parseIdioma(String[] idiomas){
		List<Idioma> aux = null;
		aux = new ArrayList<Idioma>();
		for (String idioma2 : idiomas) {
			Idioma idioma = Idioma.CASTELLANO;
			int codigoIdioma = Integer.parseInt(idioma2);
			if(codigoIdioma == Idioma.EUSKERA.getCodigo()){
				idioma = Idioma.EUSKERA;
			}else{
				if(codigoIdioma==Idioma.INGLES.getCodigo()){
					idioma = Idioma.INGLES;
				}
			}
			aux.add(idioma);
		}
		return aux;
	}
	public static boolean tryParseInt(String cadena){
		boolean exito = true;

		try {
			Integer.parseInt(cadena);
		} catch(NumberFormatException e){
			exito = false;
		}
		return exito;
	}
  public static TipoCurso parseTipo(int codTipoCurso) {
    TipoCurso tipocurso=TipoCurso.LANBIDE;
    
    tipocurso.setCodigo(codTipoCurso);
    return tipocurso;
  }

}








