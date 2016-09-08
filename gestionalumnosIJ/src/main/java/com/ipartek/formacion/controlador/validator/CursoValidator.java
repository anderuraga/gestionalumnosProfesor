package com.ipartek.formacion.controlador.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Curso;

public class CursoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Curso.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
