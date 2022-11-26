package Etappi.TicketGuru.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="lippu", types={Lippu.class})
public interface LippuProjection {
	Long getLippuid();
	UUID getLippukoodi();
	Long getHinta();
	String getKaytetty();
	List<Myyntitapahtuma> getMyyntitapahtuma();
	List<Tapahtumalipputyyppi> getTapahtumalipputyyppi();
}