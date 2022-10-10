package Etappi.TicketGuru.domain;


//import java.sql.Date;
//import java.sql.Timestamp;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Myyntitapahtuma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long myyntiid;
	
	@ManyToOne
	@JoinColumn(name = "kayttajaid")
	private Kayttaja kayttaja;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="myyntitapahtuma")
	private List <Lippu> liput;  //monta lippua myyntitapahtumassa
	
	private LocalDateTime timestamp;
	private String toteutunut ="0";  //anne lisännyt 10.10 alkuarvoksi
	
	public Myyntitapahtuma() {}
	
	//public Myyntitapahtuma(Kayttaja kayttaja, LocalDateTime timestamp) {}
	
	public Myyntitapahtuma( Kayttaja kayttaja, LocalDateTime timestamp, String toteutunut) {
		
		super();
		this.kayttaja = kayttaja;
		this.timestamp = timestamp;
		this.toteutunut = toteutunut;
	}

	public String getToteutunut() {
		return toteutunut;
	}

	public void setToteutunut(String toteutunut) {
		this.toteutunut = toteutunut;
	}

	public long getMyyntiid() {
		return myyntiid;
	}

	public void setMyyntiid(long myyntiid) {
		this.myyntiid = myyntiid;
	}

	public Kayttaja getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public List<Lippu> getLiput(){
		return liput;
	}
		
	public void setLiput(List<Lippu> liput) {
			this.liput = liput;
	}

	@Override
	public String toString() {
		return "Myyntitapahtuma [myyntiid=" + myyntiid + ", kayttaja=" + kayttaja + ", liput=" + liput + ", timestamp="
				+ timestamp + ", toteutunut=" + toteutunut + "]";
	}
}
