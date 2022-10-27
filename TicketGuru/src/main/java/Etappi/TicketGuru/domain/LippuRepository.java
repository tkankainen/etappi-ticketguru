package Etappi.TicketGuru.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "lippus", path = "liput")
public interface LippuRepository extends CrudRepository<Lippu, Long> {
	
	//List<Lippu> findByLippukoodi(String lippukoodi);
	List<Lippu> findByLippukoodi(@Param("koodi") UUID lippukoodi);

}
