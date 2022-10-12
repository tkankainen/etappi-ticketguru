package Etappi.TicketGuru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)//ei tee endpointia
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}