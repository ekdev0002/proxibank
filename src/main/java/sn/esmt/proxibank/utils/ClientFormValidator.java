package sn.esmt.proxibank.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sn.esmt.proxibank.domaine.Client;
@Component
public class ClientFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Client.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Client e = (Client) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.client.nom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty.client.prenom");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ecoleFrequentee", "notEmpty.client.ecole");

	}

}
