package com.ipartek.formacion.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ipartek.formacion.dao.persistencia.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone arg0) {
	}

	@Override
	public boolean isValid(String telefono, ConstraintValidatorContext ctx) {
		boolean valid = true;
		if (telefono == null) {
			valid = false;
		}
		if(!telefono.matches("\\+\\d{11}")){
			valid = false;
		}
		if(!telefono.matches("\\+34\\d\\d{9}")){
			valid = false;
		}
		return valid;
	}

}
