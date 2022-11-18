package Etappi.TicketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Etappi.TicketGuru.domain.Lippu;
import Etappi.TicketGuru.domain.LippuRepository;
import Etappi.TicketGuru.domain.Tapahtuma;

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
	
	@GetMapping("liput/{id}")
	Optional<Lippu> findLippu(@PathVariable("id") Long id) {
        return lippurepository.findById(id);
    }
	
	@PostMapping("liput")
	Lippu newLippu(@RequestBody Lippu newLippu) {
		return lippurepository.save(newLippu);
	}

}
