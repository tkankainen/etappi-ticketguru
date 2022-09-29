package Etappi.TicketGuru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tilas", path = "tilat")
public interface TilaRepository extends CrudRepository<Tila, Long> {
	
	List<Tila> findByNimi(String nimi);

}
