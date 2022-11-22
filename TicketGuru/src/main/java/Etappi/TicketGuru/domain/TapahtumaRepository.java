package Etappi.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(collectionResourceRel = "tapahtumas", path = "tapahtumat")
public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long>{
	//hae tapahtuma nimellä
		@RestResource(path = "nimi", rel = "nimi")
		List<Tapahtuma> findByNimi(@Param("nimi")String nimi);
		
		//hae kaupungilla
		@RestResource(path = "kaupunki", rel = "kaupunki")
		List<Tapahtuma> findByKaupunki(@Param("kaupunki")String kaupunki);
		
		//hae nimen osalla
		@RestResource(path = "nimiosa", rel = "nimiosa")
		List<Tapahtuma> findByNimiContaining(@Param("nimi")String nimi);
}
