package com.ipartek.formacion.dao.persistence;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.xml.ElementType;

import com.ipartek.formacion.controller.validator.PhoneValidator;

@Documented
@Constraint(validatedBy=PhoneValidator.class)
@Target({java.lang.annotation.ElementType.METHOD,java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
	String mensaje() default "{Phone}";
	Class<?>[] groups() default{};
	Class<?extends Payload>[] payload() default{};
}
