package Etappi.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kayttajas", path = "kayttajat")
public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {

	Optional<Kayttaja> findByTunnus(String tunnus);
	
}
