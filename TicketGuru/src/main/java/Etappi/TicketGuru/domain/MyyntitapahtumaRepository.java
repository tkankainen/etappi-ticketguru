package Etappi.TicketGuru.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "myyntitapahtumas", path = "myyntitapahtumat")
public interface MyyntitapahtumaRepository extends CrudRepository<Myyntitapahtuma, Long> {

	List<Myyntitapahtuma> findByMyyntiid(Long myyntiid);
	/*List<Myyntitapahtuma> findByMyyntiid(int myyntiid);
	List<Myyntitapahtuma> findByTimestamp(String timestamp);*/
	

}
