package com.ipartek.formacion.service.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;

import com.ipartek.formacion.pojo.Idioma;

public class I18n {

  private I18n() {

  }

  public static final String getBrowserLocale(Locale localeBrowser) {

    String result = Idioma.INGLES.getLocale();
    Locale localeEuskera = new Locale(Idioma.EUSKERA.getCodIdioma());
    Locale localeCastellano = new Locale(Idioma.CASTELLANO.getCodIdioma());
    // Locale localeIngles = new Locale(Idioma.INGLES.getCodIdioma());

    if (localeBrowser != null) {
      if (localeBrowser.getLanguage().equals(localeEuskera)) {

        result = Idioma.EUSKERA.getLocale();

      } else {
        if (localeBrowser.getLanguage().equals(localeCastellano.getLanguage())) {

          result = Idioma.CASTELLANO.getLocale();
        }
      }
    }
    return result;
  }

  public static String getString(String cadenaMensaje, Object... params) {

    // Object params --> Como es una api de java y nose que tipo de parametros o cuantos parametros
    // van a ser utilizamos los dos puntos para decirle a java que no tengo dicha informacion

    String msg = "";
    try {

      msg = MessageFormat.format(cadenaMensaje, params);

    } catch (MissingResourceException e) {
      msg = "no existe el mensaje";
    }

    return msg;

  }

  public static Locale getStringLocale(final String lang) {

    Locale loc = new Locale(Idioma.INGLES.getCodIdioma());

    if (lang != null) {
      if (lang.equalsIgnoreCase(Idioma.CASTELLANO.getCodIdioma())) {
        loc = new Locale(Idioma.CASTELLANO.getCodIdioma());
      } else {
        if (lang.equalsIgnoreCase(Idioma.EUSKERA.getCodIdioma())) {
          loc = new Locale(Idioma.EUSKERA.getCodIdioma());
        }
      }
    }
    return loc;

  }
}
