package sn.esmt.proxibank.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sn.esmt.proxibank.domaine.Recu;
@Component
public class RecuFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Recu.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Recu e = (Recu) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.recu.nom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty.recu.prenom");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ecoleFrequentee", "notEmpty.recu.ecole");

	}

}
