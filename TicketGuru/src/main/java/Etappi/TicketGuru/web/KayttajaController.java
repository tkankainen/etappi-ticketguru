package Etappi.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Etappi.TicketGuru.domain.Kayttaja;
import Etappi.TicketGuru.domain.KayttajaRepository;

@RestController
public class KayttajaController {
	
	@Autowired
	private KayttajaRepository kayttajaRepository;
	
	@GetMapping("kayttajat")
	Iterable<Kayttaja> getAll() {
        return kayttajaRepository.findAll();
    }
	
	@GetMapping("kayttajat/{id}")
	Optional<Kayttaja> findKayttaja(@PathVariable("id") Long id) {
		return kayttajaRepository.findById(id);
	}
	
	@PostMapping("kayttajat")
	Kayttaja newKayttaja(@RequestBody Kayttaja newKayttaja) {
		return kayttajaRepository.save(newKayttaja);
	}
	
	@PutMapping("/kayttajat/{id}")
	Kayttaja replaceKayttaja(@RequestBody Kayttaja newKayttaja, @PathVariable Long id) {
		newKayttaja.setKayttajaid(id);
		return kayttajaRepository.save(newKayttaja);
	}

	@DeleteMapping("/kayttajat/{id}")
	void deleteKayttaja(@PathVariable Long id) {
		kayttajaRepository.deleteById(id);
	}
	
	//PATCH

}
