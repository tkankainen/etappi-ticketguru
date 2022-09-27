package Etappi.TicketGuru.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Etappi.TicketGuru.domain.Lippu;
import Etappi.TicketGuru.domain.LippuRepository;

@RestController
public class LippuController {
	
	@Autowired
	private LippuRepository lippurepository;
	
//	@GetMapping("liput")
//	public ResponseEntity<List<Lippu>> getAllTickets() {
//		List<Lippu> list = (List<Lippu>) lippurepository.findAll();
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	@GetMapping("liput")
	Iterable<Lippu> all() {
		return lippurepository.findAll();
	}
	
	//GET hae yksittäinen lippu
	
	@PostMapping("liput")
	Lippu newLippu(@RequestBody Lippu newLippu) {
		return lippurepository.save(newLippu);
	}

}
