package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		//el return es alumno.class para que solo trabaje si el objeto es de tipo alumno
		return Alumno.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", "Nombre vacio", "Nombre requerido para el alumno");
		Alumno alum = (Alumno) obj;
		
		if(alum.getCodigo()<-1){
			errors.rejectValue("codigo", "ValorNoValido", new Object[]{"'codigo'"}, "No puede usar ese valor");
			
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "Debe introducir sus apellidos", "Apellidos requeridos para el alumno");
	}

}
