package com.ipartek.formacion.controller.validator;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Alumno.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "nombre", "");
		Alumno alum = (Alumno) obj;

		if (alum.getCodigo() < 0) {
			errors.rejectValue("codigo", "valor no valido",
					new Object[] { "'codigo'" }, "no puede ser ese valor");
		}
	}
}
