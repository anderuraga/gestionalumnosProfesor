package com.ipartek.formacion.controlador.validator;

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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "Nombre requerido");
		Modulo modulo=(Modulo) obj;
		
		if(modulo.getCodigo()<0){
			errors.rejectValue("codigo", "valorNegativo", new Object[]{"'codigo'"}, "No puede ser ese valor");
		}

	}

}
