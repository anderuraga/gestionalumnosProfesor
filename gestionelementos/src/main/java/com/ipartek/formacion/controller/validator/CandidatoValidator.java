package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Candidato;

public class CandidatoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return  Candidato.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombreCandidato", "nombre requerido");
		 Candidato  candidato = ( Candidato) obj;
		
		if(candidato.getCodigo()< -1){
			errors.rejectValue("codigoCandidato", "valorNegativo", 
					new Object[]{"'codigoCandidato'"},"no puede ser ese valor");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidosCandidato", "los apellidos no pueden estar en blanco");
		
	}

}