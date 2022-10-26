package Etappi.TicketGuru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TicketController {
	@RequestMapping(value = "/")
	@ResponseBody
	
	public String Hello(){
		return "https://etappi-ticketguru.herokuapp.com/api"; 
			    
	}

}
