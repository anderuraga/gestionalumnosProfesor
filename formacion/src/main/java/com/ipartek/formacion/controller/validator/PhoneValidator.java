package com.ipartek.formacion.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipartek.formacion.controller.AlumnosController;
import com.ipartek.formacion.dao.persistence.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private static final Logger logger = LoggerFactory.getLogger(PhoneValidator.class);
	
	@Override
	public void initialize(Phone arg0) {
		
	}

	@Override
	public boolean isValid(String telefono, ConstraintValidatorContext ctx) {
		boolean valido = true;
		
		if(telefono.equals(null))
			valido = false;
		
		if(!telefono.matches("\\+\\d{11}"))
			valido = false;
		
		if(!telefono.matches("\\+34\\d{9}"))
			valido=false;
		
		if(valido)
			logger.info("Telefono valido.");
		else
			logger.info("Error: Telefono incorrecto.");
		
		return valido;
	}
}
