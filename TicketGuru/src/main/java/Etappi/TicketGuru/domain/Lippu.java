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
	@JoinColumn(name="lipputyyppiid")
	private Tapahtumalipputyyppi tapahtumalipputyyppi;
	
	@ManyToOne
	@JoinColumn(name="myyntiid")
	private Myyntitapahtuma myyntitapahtuma;
	
	private String lippukoodi;
	private long hinta;
	
	public Lippu() {
	}

	public Lippu(long lippuid, Tapahtumalipputyyppi tapahtumalipputyyppi,
			Myyntitapahtuma myyntitapahtuma, String lippukoodi, long hinta) {
		this.lippuid = lippuid;
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
		this.myyntitapahtuma = myyntitapahtuma;
		this.lippukoodi = lippukoodi;
		this.hinta = hinta;
	}
	
	public Lippu(Tapahtumalipputyyppi tapahtumalipputyyppi, 
			Myyntitapahtuma myyntitapahtuma, String lippukoodi, long hinta) {
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
		this.myyntitapahtuma = myyntitapahtuma;
		this.lippukoodi = lippukoodi;
		this.hinta = hinta;
	}

	public long getLippuid() {
		return lippuid;
	}

	public void setLippuid(long lippuid) {
		this.lippuid = lippuid;
	}

	public Tapahtumalipputyyppi getTapahtumalipputyyppi() {
		return tapahtumalipputyyppi;
	}

	public void setTapahtumalipputyyppi(Tapahtumalipputyyppi tapahtumalipputyyppi) {
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
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

	public Myyntitapahtuma getMyyntitapahtuma() {
		return myyntitapahtuma;
	}

	public void setMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma) {
		this.myyntitapahtuma = myyntitapahtuma;
	}

	@Override
	public String toString() {
		return "Lippu [lippuid=" + lippuid + ", tapahtumalipputyyppi="
				+ tapahtumalipputyyppi + ", lippukoodi=" + lippukoodi + ", hinta=" + hinta + "]";
	}

}
