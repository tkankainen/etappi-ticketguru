package Etappi.TicketGuru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {

	List<Kayttaja> findByTunnus(String tunnus);

}
