package Etappi.TicketGuru.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Etappi.TicketGuru.domain.Lippu;

@Component("beforeCreateLippuValidator")
public class LippuValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Lippu.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Lippu lippu = (Lippu) obj;

		if (checkInputString(lippu.getLippukoodi())) {
            errors.rejectValue("lippukoodi", "lippukoodi.empty");
        }
		if (checkInputLong(lippu.getHinta())) {
            errors.rejectValue("hinta", "hinta.empty");
        }
	}
	
	private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
	
	private boolean checkInputLong(Long input) {
        return (input == 0 || input < 0);
    }
}
