package Etappi.TicketGuru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lippu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lippuid;
	
	@ManyToOne
	@JoinColumn(name="tapahtumaid")
	private Tapahtuma tapahtuma;
	
	@ManyToOne
	@JoinColumn(name="lipputyyppiid")
	private Tapahtumalipputyyppi tapahtumalipputyyppi;
	
	@ManyToOne
	@JoinColumn(name="tilaid")
	private Tila tila;
	
//	@ManyToOne
//	@JoinColumn(name="myyntiid")
//	private Myyntitapahtuma myyntitapahtuma;
	
//	lisää myyntitapahtuma getterit ja setterit
	
	private String lippukoodi;
	private long hinta;
	
	public Lippu() {
	}

	public Lippu(long lippuid, Tapahtuma tapahtuma, Tapahtumalipputyyppi tapahtumalipputyyppi, Tila tila,
			String lippukoodi, long hinta) {
		this.lippuid = lippuid;
		this.tapahtuma = tapahtuma;
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
		this.tila = tila;
		this.lippukoodi = lippukoodi;
		this.hinta = hinta;
	}

	public long getLippuid() {
		return lippuid;
	}

	public void setLippuid(long lippuid) {
		this.lippuid = lippuid;
	}

	public Tapahtuma getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(Tapahtuma tapahtuma) {
		this.tapahtuma = tapahtuma;
	}

	public Tapahtumalipputyyppi getTapahtumalipputyyppi() {
		return tapahtumalipputyyppi;
	}

	public void setTapahtumalipputyyppi(Tapahtumalipputyyppi tapahtumalipputyyppi) {
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
	}

	public Tila getTila() {
		return tila;
	}

	public void setTila(Tila tila) {
		this.tila = tila;
	}

	public String getLippukoodi() {
		return lippukoodi;
	}

	public void setLippukoodi(String lippukoodi) {
		this.lippukoodi = lippukoodi;
	}

	public long getHinta() {
		return hinta;
	}

	public void setHinta(long hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Lippu [lippuid=" + lippuid + ", tapahtuma=" + tapahtuma + ", tapahtumalipputyyppi="
				+ tapahtumalipputyyppi + ", tila=" + tila + ", lippukoodi=" + lippukoodi + ", hinta=" + hinta + "]";
	}

}
