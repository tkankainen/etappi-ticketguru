package Etappi.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import Etappi.TicketGuru.domain.Myyntitapahtuma;
import Etappi.TicketGuru.domain.MyyntitapahtumaRepository;

@RestController
public class MyyntitapahtumaController {
	
	@Autowired
	private MyyntitapahtumaRepository myyntitapahtumarepository;
	
//	@GetMapping("liput")
//	public ResponseEntity<List<Lippu>> getAllTickets() {
//		List<Lippu> list = (List<Lippu>) lippurepository.findAll();
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	@GetMapping("myyntitapahtumat")
	Iterable<Myyntitapahtuma> all() {
		return myyntitapahtumarepository.findAll();
	}
	
	@PostMapping("myyntitapahtumat")
	Myyntitapahtuma newMyyntitapahtuma(@RequestBody Myyntitapahtuma newMyyntitapahtuma) {
		return myyntitapahtumarepository.save(newMyyntitapahtuma);
	}

}
