package Etappi.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "lippus", path = "liput")
public interface LippuRepository extends CrudRepository<Lippu, Long> {
	
	List<Lippu> findByLippukoodi(String lippukoodi);

}
