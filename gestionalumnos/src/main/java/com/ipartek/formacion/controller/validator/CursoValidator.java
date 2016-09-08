package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Curso;

public class CursoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Curso.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "curso", "Nombre del Curso requerido");
		
		Curso curso = (Curso) obj;
		if(curso.getNombre().length() < 4){
			errors.rejectValue("codigo", "valorNegativo", new Object[]{"'codigo'"}, "El nombre del curso debe tener más de 3 letras");
		}
	}
	

}