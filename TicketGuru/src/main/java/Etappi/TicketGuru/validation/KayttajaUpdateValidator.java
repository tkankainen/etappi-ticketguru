package Etappi.TicketGuru.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Etappi.TicketGuru.domain.Kayttaja;

@Component("beforeSaveKayttajaValidator")

public class KayttajaUpdateValidator implements Validator {
	
	@Override
    public boolean supports(Class<?> clazz) {
        return Kayttaja.class.equals(clazz);
    }
  @Override
    public void validate(Object obj, Errors errors) {

        Kayttaja kayttaja = (Kayttaja) obj;
        if (checkInputString(kayttaja.getEtunimi())) {
            errors.rejectValue("etunimi", "etunimi.empty");
        }

        if (checkInputString(kayttaja.getSukunimi())) {
            errors.rejectValue("sukunimi", "sukunimi.empty");
        }
        
        if (checkInputString(kayttaja.getTunnus())) {
            errors.rejectValue("tunnus", "tunnus.empty");
        }
        
        if (checkInputString(kayttaja.getSalasana())) {
            errors.rejectValue("salasana", "salasana.empty");
        }
        
        if (checkInputString(kayttaja.getRooli())) {
            errors.rejectValue("rooli", "rooli.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }

}
