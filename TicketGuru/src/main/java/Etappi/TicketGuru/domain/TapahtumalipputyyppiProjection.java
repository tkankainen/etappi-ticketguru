package Etappi.TicketGuru.domain;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="lipputyyppi", types={Tapahtumalipputyyppi.class})
public interface TapahtumalipputyyppiProjection {
	Long getLipputyyppiid();
	Long getHinta();
	String getNimi();
	List<Tapahtuma> getTapahtuma();
}