package com.ipartek.formacion.controlador.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Curso;

public class CursoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Curso.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombreInvalido", "Nombre requerido");
		Curso curso = (Curso) obj;
		if(curso.getNombre().length()<=3){
			errors.rejectValue("nombre", "nombreCorto", new Object[]{"'nombre'"}, "Debe contener mas de 3 caracteres");
		}
	}

}
