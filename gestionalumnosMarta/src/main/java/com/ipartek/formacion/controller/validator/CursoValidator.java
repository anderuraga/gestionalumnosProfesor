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
		Curso cur = (Curso) obj;
		
		
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreRequerido", "nombre requerido");
		
		if(cur.getCodigo()<-1){
			errors.rejectValue("codigo","valorNegativo", new Object[]{"'codigo'"},"no puede ser ese valor" );
		}
		
		if(cur.getNombre().length()<3){
			errors.rejectValue("nombre","valorNegativo", new Object[]{"'nombre'"},"minimo 3 caracteres" );
		}
	}

}
