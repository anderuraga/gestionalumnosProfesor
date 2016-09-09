package com.ipartek.formacion.controller.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Alumno;

public class AlumnoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Alumno.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Alumno alum = (Alumno) obj;
		Date fechaHoy= new Date();
		String patternEmail = "[A-Za-z0-9+_.-]+@(.+)$";
		
		
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreRequerido", "nombre requerido");
		ValidationUtils.rejectIfEmpty(errors, "apellidos", "apellidosRequeridos", "apellidos requeridos");
		ValidationUtils.rejectIfEmpty(errors, "fNacimiento", "fechaRequerida", "fecha nacimiento requerida");
		ValidationUtils.rejectIfEmpty(errors, "email", "emailRequerido", "email requerido");
		
		if(alum.getCodigo()<-1){
			errors.rejectValue("codigo","valorNegativo", new Object[]{"'codigo'"},"no puede ser ese valor" );
			//new Object[]{} array asociativo
		}
		
		
		if(alum.getfNacimiento().compareTo(fechaHoy)>0){
			
			errors.rejectValue("fNacimiento","valorNegativo", new Object[]{"'fNacimiento'"},"fecha incorrecta" );
		}
		
		if(alum.getEmail()!="" && !alum.getEmail().matches(patternEmail)){
			errors.rejectValue("email","valorNegativo", new Object[]{"'email'"},"email incorrecto" );
		}
	}

}
