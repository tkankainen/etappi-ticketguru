package Etappi.TicketGuru.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Etappi.TicketGuru.domain.Tapahtuma;
import Etappi.TicketGuru.domain.TapahtumaRepository;

@RestController
public class TapahtumaController {
	
	private TapahtumaRepository tapahtumaRepository;
	
	TapahtumaController(TapahtumaRepository tapahtumaRepository) {
		this.tapahtumaRepository = tapahtumaRepository;
	}
	
	@GetMapping("tapahtumat")
	Iterable<Tapahtuma> getAll() {
        return tapahtumaRepository.findAll();
    }
	
	@GetMapping("tapahtumat/{id}")
	Optional<Tapahtuma> findTapahtuma(@PathVariable("id") Long id) {
        return tapahtumaRepository.findById(id);
    }
	
	@PostMapping("tapahtumat")
	Tapahtuma newTapahtuma(@RequestBody Tapahtuma newTapahtuma) {
		return tapahtumaRepository.save(newTapahtuma);
	}
	
	@PutMapping("/tapahtumat/{id}")
	Tapahtuma replaceTapahtuma(@RequestBody Tapahtuma newTapahtuma, @PathVariable Long id) {
		newTapahtuma.setTapahtumaid(id);
		return tapahtumaRepository.save(newTapahtuma);
	}

	@DeleteMapping("/tapahtumat/{id}")
	void deleteTapahtuma(@PathVariable Long id) {
		tapahtumaRepository.deleteById(id);
	}

}
