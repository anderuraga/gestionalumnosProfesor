package com.ipartek.formacion.controlador.validator;

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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "Nombre requerido");
		Curso curso=(Curso) obj;
		
		if(curso.getCodigo()<0){
			errors.rejectValue("codigo", "valorNegativo", new Object[]{"'codigo'"}, "No puede ser ese valor");
		}
	}

}
