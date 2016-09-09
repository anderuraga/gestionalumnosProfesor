package com.ipartek.formacion.dao.persistence;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ipartek.formacion.controller.validator.PhoneValidator;

@Documented
@Constraint(validatedBy = {PhoneValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
	String menssage() default "{Phone}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}