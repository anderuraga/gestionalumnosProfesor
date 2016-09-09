package com.ipartek.formacion.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ipartek.formacion.dao.persistencia.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, String>{

	@Override
	public void initialize(Phone arg0) {
		//no desarrolla xq no hay clase Phone
	}

	@Override
	public boolean isValid(String telefono, ConstraintValidatorContext arg1) {
		boolean valido = true;
		
		if(telefono == null){
			valido = false;
		}
		if(telefono.matches("\\+\\d{11}")){
			valido = false;
		}
		if(telefono.matches("\\+34\\d{9}")){
			valido = false;
		}
		return valido;
	}

}
