package com.ipartek.formacion.controller.validator;

import javax.swing.Spring;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ipartek.formacion.dao.persistencia.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, String>{

	@Override
	public void initialize(Phone arg0) {
		
	}

	@Override
	public boolean isValid(String telefono, ConstraintValidatorContext ctx) {
		boolean valido = true;
		
		if(telefono == null){
			valido = false;
		}
		
		if(!telefono.matches("\\+\\d(11)")){
			valido = false;
		}
		if(!telefono.matches("+34\\d(9)")){
			valido = false;
		}
		
		return valido;
	}

}
