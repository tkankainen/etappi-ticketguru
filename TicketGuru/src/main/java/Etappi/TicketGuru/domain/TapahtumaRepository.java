package Etappi.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "tapahtumas", path = "tapahtumat")
public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long>{
	List<Tapahtuma> findByNimi(String nimi);
}
