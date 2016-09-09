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
		Modulo mod = (Modulo) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreRequerido", "nombre requerido");
		
		if(mod.getCodigo()<-1){
			errors.rejectValue("codigo","valorNegativo", new Object[]{"'codigo'"},"no puede ser ese valor" );
		}
		
		if(mod.getDuracion()<0 || mod.getDuracion()>5){ //en duracion tengo los codigos
			errors.rejectValue("duracion","valorNegativo", new Object[]{"'duracion'"},"la duracion no es válida" );
		}
		
	}

}
