package sn.esmt.proxibank.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sn.esmt.proxibank.domaine.Conseiller;
@Component
public class ConseillerFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Conseiller.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Conseiller e = (Conseiller) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.conseiller.nom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty.conseiller.prenom");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ecoleFrequentee", "notEmpty.conseiller.ecole");

	}

}
