package Etappi.TicketGuru.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Etappi.TicketGuru.domain.Tapahtuma;


@Component("beforeCreateTapahtumaValidator")

public class TapahtumaValidator implements Validator{
	
	  @Override
	    public boolean supports(Class<?> clazz) {
	        return Tapahtuma.class.equals(clazz);
	    }
	  @Override
	    public void validate(Object obj, Errors errors) {

	        Tapahtuma tapahtuma = (Tapahtuma) obj;
	        if (checkInputString(tapahtuma.getNimi())) {
	            errors.rejectValue("nimi", "nimi.empty");
	        }

	        if (checkInputString(tapahtuma.getOsoite())) {
	            errors.rejectValue("osoite", "osoite.empty");
	        }
	        
	        if (checkInputString(tapahtuma.getKaupunki())) {
	            errors.rejectValue("kaupunki", "kaupunki.empty");
	        }
	        if (checkInputLong(tapahtuma.getKpl())) {
	            errors.rejectValue("kpl", "kpl.empty");
	        }
	    }

	    private boolean checkInputString(String input) {
	        return (input == null || input.trim().length() == 0);
	    }
	    
	    private boolean checkInputLong(Long input) {
	        return (input == 0 || input < 0);
	    }
}
