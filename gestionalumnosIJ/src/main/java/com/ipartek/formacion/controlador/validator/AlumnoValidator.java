package com.ipartek.formacion.controlador.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Alumno;

/**
 * 
 * @author Curso
 * 
 */
public class AlumnoValidator implements Validator {
	private static final Logger logger = LoggerFactory
			.getLogger(AlumnoValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		return Alumno.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreRequerido",
				"Nombre requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido",
				"apellidosRequeridos", "Apellidos requeridos");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fNacimiento",
				"fNacimientosRequerida", "Fecha de nacimiento requerida");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"emailRequeridos", "Email requerido");
		Alumno alum = (Alumno) obj;
		if (alum.getCodigo() < 0) {
			errors.rejectValue("codigo", "valorNegativo",
					new Object[] { "'codigo'" }, "No puede ser ese valor");
		}
		
		if (alum.getfNacimiento().compareTo(new Date()) >= 0) {
			errors.rejectValue("fNacimiento", "fechaInvalida",
					new Object[] { "'fNacimiento'" },
					"La fecha debe ser anterior al dia de hoy");
		}
		if (!alum.getEmail().matches("[0-9a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]{1,3}")) {
			errors.rejectValue("email", "emailInvalido",
					new Object[] { "'email'" },
					"El email tiene un formato no valido");
		}

	}

}
