package Etappi.TicketGuru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kayttajas", path = "kayttajat")
public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {

	List<Kayttaja> findByTunnus(String tunnus);
	
	

}
