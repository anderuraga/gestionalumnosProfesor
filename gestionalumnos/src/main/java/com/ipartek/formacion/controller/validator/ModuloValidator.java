package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {

		return Modulo.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", "Nombre requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uFormativa", "Unidad formativa requerida");
		Modulo mod = (Modulo) obj;
		
		if(mod.getCodigo()<0){
			errors.rejectValue("codigo", "ValorNoValido", new Object[]{"'codigo'"}, "No puede usar ese valor");
		}
		if(mod.getDuracion()>125 || mod.getDuracion()<0){
			errors.rejectValue("duracion", "DuracionNoValida", new Object[]{"'duracion'"}, "La duracion del modulo debe estar entre 0 y 125 horas.");
		}
		
	}


}
