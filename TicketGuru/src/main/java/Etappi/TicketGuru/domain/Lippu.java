package Etappi.TicketGuru.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	
	private long hinta;
	private String kaytetty;
	
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "lippukoodi", columnDefinition = "uuid", unique = true, nullable = false)
	@Type(type="pg-uuid") //type="uuid-char" mikäli käytössä h2
	private UUID lippukoodi;
	
	@PrePersist
    protected void onCreate() {
        setLippukoodi(UUID.randomUUID());
    }
	
	public Lippu() {
	}

	public Lippu(long lippuid, Tapahtumalipputyyppi tapahtumalipputyyppi,
			Myyntitapahtuma myyntitapahtuma, UUID lippukoodi, long hinta,String kaytetty) {
		this.lippuid = lippuid;
		this.tapahtumalipputyyppi = tapahtumalipputyyppi;
		this.myyntitapahtuma = myyntitapahtuma;
		this.lippukoodi = lippukoodi;
		this.hinta = hinta;
		this.kaytetty=kaytetty;
	}
	
	public Lippu(Tapahtumalipputyyppi tapahtumalipputyyppi, 
			Myyntitapahtuma myyntitapahtuma, UUID lippukoodi, long hinta,String kaytetty) {
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

	public UUID getLippukoodi() {
		return lippukoodi;
	}

	public void setLippukoodi(UUID lippukoodi) {
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

}
