package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Alumno.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Alumno alum = (Alumno) obj;
		
		if(alum.getCodigo()<-1){
			errors.rejectValue("codigo", "errorCodigo", 
					new Object[]{"'codigo'"}, "Error: Codigo incorrecto");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "errorNombre", "Error: Nombre requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "errorApellidos" ,"Error: Apellidos requeridos");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni_nie", "error_dni_nie" ,"Error: DNI requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fNacimiento", "errorFNacimiento" ,"Error: Fecha de nacimiento requerida");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errorEmail" ,"Error: Email requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "errorTelefono" ,"Error: Telefono requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codGenero", "errorCodGenero" ,"Error: Codigo de genero requerido");
		
		if(alum.getCodGenero()<1 || alum.getCodGenero()>3){
			errors.rejectValue("codGenero", "errorCodGenero", 
					new Object[]{"'codigo'"}, "Error: El codigo de genero debe ser 1, 2 o 3");
		}
	}

}
