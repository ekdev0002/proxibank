package sn.esmt.proxibank.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sn.esmt.proxibank.domaine.Piece;
@Component
public class PieceFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Piece.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Piece e = (Piece) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.piece.nom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty.piece.prenom");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ecoleFrequentee", "notEmpty.piece.ecole");

	}

}
