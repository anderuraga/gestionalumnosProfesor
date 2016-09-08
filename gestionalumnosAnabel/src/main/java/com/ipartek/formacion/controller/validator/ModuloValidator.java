package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Modulo;

public class ModuloValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {

		return Modulo.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","nombreVacio","El nombre no puede estar en blanco"); 
		Modulo modulo = (Modulo) object;
		if(modulo.getDuracion() < 0 || modulo.getDuracion() > 125){
			errors.rejectValue("duracion", "valorInvalido", new Object[]{"duracion"}, "El valor no es valido");
		}
	}

}
