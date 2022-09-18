package Etappi.TicketGuru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TilaRepository extends CrudRepository<Tila, Long> {
	
	List<Tila> findByNimi(String nimi);

}
