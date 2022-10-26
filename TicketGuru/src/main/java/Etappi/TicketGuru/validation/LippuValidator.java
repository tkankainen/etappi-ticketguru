package Etappi.TicketGuru.validation;

import java.util.UUID;

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

		if (checkInput(lippu.getLippukoodi())) {
            errors.rejectValue("lippukoodi", "lippukoodi.empty");
        }
	}
	
	private boolean checkInput(UUID uuid) {
        return (uuid == null);
    }
}
