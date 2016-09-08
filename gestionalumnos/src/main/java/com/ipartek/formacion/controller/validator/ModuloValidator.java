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
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", "Nombre del recurso requerido");
		
		Modulo modulo = (Modulo) obj;
		
		if(modulo.getDuracion() < 0 || modulo.getDuracion() > 125){
			errors.rejectValue("codigo", "duracionErronea", new Object[]{"'duracion'"}, "Duración errónea");
		}
		
	}

}