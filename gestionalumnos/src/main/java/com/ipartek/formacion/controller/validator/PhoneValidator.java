package com.ipartek.formacion.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ipartek.formacion.dao.persistence.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, String>{

	@Override
	public void initialize(Phone arg0) {
		//No tenemos una clase llamada telefono, por lo que no se puede obligar a que solo trabaje con esa clase.
	}

	@Override
	public boolean isValid(String telefono, ConstraintValidatorContext ctx) {
		boolean valido = true;
		
		if(telefono==null)
		{
			valido=false;
		}
		if(!telefono.matches("\\+\\d{11}")){ //obligo a que metan once digitos y el + del prefijo extranjero
			valido=false;
		}
		if(!telefono.matches("\\+34\\d{9}")){//aqui por narices es +34 y nueve digitos
			valido=false;
		}
		//aqui seguimos añadiendo reglas para filtar y capar todas las posibilidades disponibles
		
		return valido;
	}

}
