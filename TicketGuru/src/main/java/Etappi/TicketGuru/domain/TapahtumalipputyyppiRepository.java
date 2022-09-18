package Etappi.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;




public interface TapahtumalipputyyppiRepository extends CrudRepository<Tapahtumalipputyyppi, Long>{
	
		List<Tapahtumalipputyyppi> findByHinta(long hinta);
		
	
}
