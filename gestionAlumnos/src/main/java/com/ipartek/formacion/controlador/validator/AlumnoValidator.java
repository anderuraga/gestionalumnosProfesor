package com.ipartek.formacion.controlador.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Alumno;

public class AlumnoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		//Comprueba que la clase que recibe sea un Alumno
		return Alumno.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", " ", "Nombre requerido");
		Alumno alum=(Alumno) obj;
		
		if(alum.getCodigo()<0){
			errors.rejectValue("codigo", "valorNegativo", new Object[]{"'codigo'"}, "No puede ser ese valor");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "los apellidos no pueden estar en blanco");
		
	}
	
}
