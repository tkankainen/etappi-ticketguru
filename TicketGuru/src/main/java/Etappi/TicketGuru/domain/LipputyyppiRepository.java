package Etappi.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "lipputyyppis", path = "lipputyypit")
public interface LipputyyppiRepository extends CrudRepository<Lipputyyppi, Long> {
	
	List<Lipputyyppi> findByNimi(String nimi);

}
