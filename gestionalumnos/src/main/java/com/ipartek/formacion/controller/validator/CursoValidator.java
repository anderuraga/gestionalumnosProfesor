package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;

public class CursoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Curso.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", "Nombre requerido", "Nombre requerido");
		Curso cur = (Curso) obj;
		
		if(cur.getCodigo()<0){
			errors.rejectValue("codigo", "ValorNoValido", new Object[]{"'codigo'"}, "No puede usar ese valor");
			
		}
		
		
	}

}
