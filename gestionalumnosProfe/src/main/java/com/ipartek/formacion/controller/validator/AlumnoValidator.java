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
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombre.required");
		Alumno alum=(Alumno) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "apellidos.required");
	}

}
