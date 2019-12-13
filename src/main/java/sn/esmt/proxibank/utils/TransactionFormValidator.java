package sn.esmt.proxibank.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sn.esmt.proxibank.domaine.Transaction;
@Component
public class TransactionFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Transaction.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Transaction e = (Transaction) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "montant", "NotEmpty.transaction.montant");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "compte", "NotEmpty.transaction.compte");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ecoleFrequentee", "notEmpty.transaction.ecole");

	}

}
