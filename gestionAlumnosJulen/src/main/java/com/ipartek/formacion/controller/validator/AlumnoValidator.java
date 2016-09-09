package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Alumno.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreBlanco","nombre en blanco");
		Alumno alum = (Alumno) obj;
		
		if(alum.getCodigo()<-1)
		{
			errors.rejectValue("codigo", "valorNegativo", new Object[]{"'codigo'"}, "No puede ser ese valor");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "No puede estar en blanco");
	}

}
