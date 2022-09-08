package Etappi.TicketGuru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TicketController {
	@RequestMapping(value = "/hello")
	@ResponseBody
	
	/*public String login(){
		return "/hello";
	}*/
	
	public String Hello(){
		return "TicketGuru aloitus Team Etappi : Elia, Taina, Pertti, Anne(feat1) 8.9.2022 ";//selaimessa http://localhost:8080/hello
	}

}
