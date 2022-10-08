package Etappi.TicketGuru.validation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Etappi.TicketGuru.domain.Myyntitapahtuma;

@Component("beforeSaveTapahtumaValidator")
public class MyyntitapahtumaUpdateValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return Myyntitapahtuma.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		Myyntitapahtuma myyntitapahtuma = (Myyntitapahtuma) obj;
		if (checkLocalDateTime(myyntitapahtuma.getTimestamp())) {
            errors.rejectValue("timestamp", "timestamp.empty");
        }
		if (checkInputString(myyntitapahtuma.getToteutunut())) {
            errors.rejectValue("toteutunut", "toteutunut.empty");
        }
	}
	
	private boolean checkLocalDateTime(LocalDateTime timestamp) {
        return (timestamp == null);
    }
	private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }

}