package Etappi.TicketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import Etappi.TicketGuru.domain.Myyntitapahtuma;
import Etappi.TicketGuru.domain.MyyntitapahtumaRepository;




@RestController
public class MyyntitapahtumaController {
	
	@Autowired
	private MyyntitapahtumaRepository myyntitapahtumarepository;
	
	
	@GetMapping("myyntitapahtumat")
	Iterable<Myyntitapahtuma> all() {
		return myyntitapahtumarepository.findAll();
	}
	
	// RESTful service to get myyntitapahtuma by id
    @RequestMapping(value="/myyntitapahtumat/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Myyntitapahtuma> findMyyntitapahtumaRest(@PathVariable("id") Long myyntiid) {	
    	return myyntitapahtumarepository.findById(myyntiid);
    }       
	    	
	@PostMapping("myyntitapahtumat")
	Myyntitapahtuma newMyyntitapahtuma(@RequestBody Myyntitapahtuma newMyyntitapahtuma) {
		return myyntitapahtumarepository.save(newMyyntitapahtuma);
	}

	
}
