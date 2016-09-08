package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Alumno;

public class AlumnoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {

		/*
		 * Validamos si es un alumno lo que estamos recibiendo
		 */
		return Alumno.class.equals(arg0); 
	}
	
	/*
	 *	Estos errores que se estan metiendo aqui, va a ser el mensaje que se va a mostrar con form:errors en la vista
	 */
	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreVacio", "Nombre requerido");
		Alumno alumno = (Alumno) object;
		if(alumno.getCodigo() < 0){
			errors.rejectValue("codigo", "valorNegativo", new Object[]{"'codigo'"},"no puede ser ese valor");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "Los apellidos no pueden estar en blanco");
	}

}
