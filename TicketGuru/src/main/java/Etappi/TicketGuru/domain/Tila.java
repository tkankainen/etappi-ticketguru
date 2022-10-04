package Etappi.TicketGuru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tila {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tilaid;
	
	private String nimi;
	
	public Tila() {
	}

	public Tila(String nimi) {
		this.nimi = nimi;
	}

	public long getTilaid() {
		return tilaid;
	}

	public void setTilaid(long tilaid) {
		this.tilaid = tilaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Tila [tilaid=" + tilaid + ", nimi=" + nimi + "]";
	}

}
