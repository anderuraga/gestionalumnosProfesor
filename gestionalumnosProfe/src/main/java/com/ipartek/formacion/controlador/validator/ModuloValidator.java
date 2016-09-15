package com.ipartek.formacion.controlador.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloValidator implements Validator {
	private static final Logger logger = LoggerFactory
			.getLogger(ModuloValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		return Modulo.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
				"nombreNulo", "Nombre requerido");
		Modulo modulo = (Modulo) obj;
		if (modulo.getDuracion() < 0 || modulo.getDuracion() > 5) {
			errors.rejectValue("duracion", "duracionInvalida",
					new Object[] { "'duracion'" }, "Duracion no valida");
		}
	}

}
