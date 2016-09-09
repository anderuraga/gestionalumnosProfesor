package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Curso;

public class CursoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {

		return Curso.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Curso curso = (Curso) object;
		//if(curso.getNombre()    /^[a-z\d_]{4,15}$/i  )
	}

}
