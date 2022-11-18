package Etappi.TicketGuru.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import Etappi.TicketGuru.domain.Tapahtumalipputyyppi;

@Component("beforeCreateTapahtumalipputyyppiValidator")
public class TapahtumalipputyyppiValidator implements Validator{
	@Override
    public boolean supports(Class<?> clazz) {
        return Tapahtumalipputyyppi.class.equals(clazz);
    }
  @Override
    public void validate(Object obj, Errors errors) {

        Tapahtumalipputyyppi tapahtumalipputyyppi = (Tapahtumalipputyyppi) obj;
       
        if (checkInputLong(tapahtumalipputyyppi.getHinta())) {
            errors.rejectValue("hinta", "hinta.empty");
        }
    }

  
    private boolean checkInputLong(Long input) {
        return (input == 0 || input < 0);
    }

}
