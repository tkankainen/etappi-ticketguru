package Etappi.TicketGuru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MyyntitapahtumaRepository extends CrudRepository<Myyntitapahtuma, Long> {

	List<Myyntitapahtuma> findByMyyntiid(Long myyntiid);

}
