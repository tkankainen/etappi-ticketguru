package Etappi.TicketGuru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Kayttaja, Long> {

//	List<User> findByName(String etunimi);

}
