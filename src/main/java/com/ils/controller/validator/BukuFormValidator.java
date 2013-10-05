package com.ils.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ils.entity.Buku;

/**
 * @author danangku
 *
 */

@Component("bukuFormValidator")
public class BukuFormValidator implements Validator {

	 @SuppressWarnings("unchecked")
	 @Override
	 public boolean supports(Class clazz){
	  return Buku.class.isAssignableFrom(clazz);
	 }

	 @Override
	 public void validate(Object model, Errors errors){
	  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "judul","required.judul", "Judul is required.");
	 }


}
