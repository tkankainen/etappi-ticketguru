package Etappi.TicketGuru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Myyntitapahtuma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long myyntiid;
	
	@ManyToOne
	@JoinColumn(name = "kayttajaid")
	private Kayttaja kayttaja;
	
	private String timestamp;
	
	public Myyntitapahtuma() {}
	
	public Myyntitapahtuma(long myyntiid, Kayttaja kayttaja, String timestamp) {
		
		super();
		this.kayttaja = kayttaja;
		this.timestamp = timestamp;
	}

	public long getMyyntiid() {
		return myyntiid;
	}

	public void setMyyntiid(long myyntiid) {
		this.myyntiid = myyntiid;
	}

	public User getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Myyntitapahtuma [myyntiid=" + myyntiid + ", kayttaja=" + this.getKayttaja() + ", timestamp=" + timestamp + "]";
	}
	
	
	

}
