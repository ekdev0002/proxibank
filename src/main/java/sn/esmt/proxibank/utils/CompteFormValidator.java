package sn.esmt.proxibank.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sn.esmt.proxibank.domaine.Compte;
@Component
public class CompteFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Compte.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Compte e = (Compte) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero", "NotEmpty.compte.numero");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categorie", "NotEmpty.compte.categorie");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "proprietaire", "NotEmpty.compte.proprietaire");		
	}

}
