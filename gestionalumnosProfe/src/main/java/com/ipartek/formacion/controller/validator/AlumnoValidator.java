package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoValidator implements Validator{

	@Override
	public boolean supports(Class<?> object) {
		
		return Alumno.class.equals(object);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", "valorNegativo");
		Alumno alum=(Alumno) obj;
		if(alum.getCodigo()<-1){
			errors.rejectValue("codigo", "valor no valido", new Object[]{"'codigo'"},"no puede ser ese valor");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "los apellidos no pueden estar en blanco");
	}

}
