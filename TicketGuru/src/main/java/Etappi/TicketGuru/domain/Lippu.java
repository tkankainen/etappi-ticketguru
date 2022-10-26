package Etappi.TicketGuru.domain;

import java.util.UUID;

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
	
	@ManyToOne(optional = false)
	@JoinColumn(name="lipputyyppiid")
	private Tapahtumalipputyyppi tapahtumalipputyyppi;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="myyntiid")
	private Myyntitapahtuma myyntitapahtuma;
	
	private String lippukoodi = usingRandomUUID();
	private long hinta;
	private String kaytetty;
	
	public Lippu() {
	}

	public Lippu(long lippuid, Tapahtumalipputyyppi tapahtumalipputyyppi,
			Myyntitapahtuma myyntitapahtuma, String lippukoodi, long hinta,String kaytetty) {
		this.lippuid = lippuid;
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
		this.myyntitapahtuma = myyntitapahtuma;
		this.lippukoodi = lippukoodi;
		this.hinta = hinta;
		this.kaytetty=kaytetty;
	}
	
	public Lippu(Tapahtumalipputyyppi tapahtumalipputyyppi, 
			Myyntitapahtuma myyntitapahtuma, String lippukoodi, long hinta,String kaytetty) {
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
		this.myyntitapahtuma = myyntitapahtuma;
		this.lippukoodi = lippukoodi;
		this.hinta = hinta;
		this.kaytetty=kaytetty;
	}
	
	public Lippu(Tapahtumalipputyyppi tapahtumalipputyyppi, 
			Myyntitapahtuma myyntitapahtuma, long hinta,String kaytetty) {
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
		this.myyntitapahtuma = myyntitapahtuma;
		this.hinta = hinta;
		this.kaytetty=kaytetty;
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

	public String getKaytetty() {
		return kaytetty;
	}

	public void setKaytetty(String kaytetty) {
		this.kaytetty = kaytetty;
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
	
	static String usingRandomUUID() {

	    UUID randomUUID = UUID.randomUUID(); //random 32-merkkinen koodi

	    return randomUUID.toString().replaceAll("_", "");

	  }

}
