package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Modulo.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Modulo modul = (Modulo) obj;
		
		if(modul.getCodigo()<-1){
			errors.rejectValue("codigo", "errorCodigo", 
					new Object[]{"'codigo'"}, "Error: Codigo incorrecto");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "nombre", "errorNombre", "Error: Nombre requerido");
		
		ValidationUtils.rejectIfEmpty(errors, "uFormativa", "errorUFormativa", "Error: Unidad Formativa requerida");
		
		if(modul.getDuracion()<1 || modul.getDuracion()>125){
			errors.rejectValue("duracion", "errorDuracion", 
					new Object[]{"'duracion'"}, "Error: La duracion debe ser entre 1 y 125.");
		}
	}

}
