package Etappi.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "tapahtumalipputyyppis", path = "tapahtumalipputyyppit")
public interface TapahtumalipputyyppiRepository extends CrudRepository<Tapahtumalipputyyppi, Long>{
	
		List<Tapahtumalipputyyppi> findByHinta(long hinta);
		
	
}
