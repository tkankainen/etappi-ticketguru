package Etappi.TicketGuru.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Etappi.TicketGuru.domain.Kayttaja;
import Etappi.TicketGuru.domain.KayttajaRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	@Autowired
	private KayttajaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String tunnus) throws UsernameNotFoundException {
		Optional<Kayttaja> user = repository.findByTunnus(tunnus);

		UserBuilder builder = null;
		if (user.isPresent()) {
			Kayttaja currentUser = user.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(tunnus);
			builder.password(currentUser.getSalasana());
			builder.roles(currentUser.getRooli());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();	    
	}
}