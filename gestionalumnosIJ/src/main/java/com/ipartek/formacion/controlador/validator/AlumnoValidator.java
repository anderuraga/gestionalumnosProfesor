package com.ipartek.formacion.controlador.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
//	private static final Logger logger = LoggerFactory
//			.getLogger(AlumnoValidator.class);

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
				"fNacimientoRequerida", "Fecha de nacimiento requerida");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"emailRequeridos", "Email requerido");	
		Alumno alum = (Alumno) obj;
		if (alum.getCodigo() < 0) {
			errors.rejectValue("codigo", "valorNegativo",
					new Object[] { "'codigo'" }, "No puede ser ese valor");
		}
		Calendar cal1= new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();
		cal1.setTime(alum.getfNacimiento());
		cal2.setTime(new Date());
		
		cal1.set(Calendar.HOUR, 0);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		
		cal2.set(Calendar.HOUR, 0);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		if (cal1.compareTo(cal2) >= 0) {
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
