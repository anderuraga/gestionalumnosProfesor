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
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombre requerido");
		
		Modulo modul = (Modulo) obj;
		
		if(modul.getCodigo()<0){
			errors.rejectValue("codigo", "valorNegativo", 
					new Object[]{"'codigo'"}, "no puede ser ese valor");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "uFormativa", "unidad formativa requerida");
		
		if(modul.getDuracion()<1 || modul.getDuracion()>125){
			errors.rejectValue("duracion", "valorErroneo", 
					new Object[]{"'duracion'"}, "no puede ser ese valor");
		}
	}

}
